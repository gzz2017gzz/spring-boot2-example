package com.gzz.common.config;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.gzz.study.sys.sysuser.SysUser;
import com.gzz.study.sys.sysuser.SysUserService;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SysUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
		String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
		// 如果不是映射到方法直接通过
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		// 检查是否有passtoken注释，有则跳过认证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		// 检查有没有需要用户权限的注解
		if (method.isAnnotationPresent(UserLoginToken.class)) {
			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
			if (userLoginToken.required()) {
				// 执行认证
				if (token == null) {
					throw new RuntimeException("无token，请重新登录");
				}
				// 获取 token 中的 user id
				Long userId;
				try {
					userId = JwtToken.getAppUID(token);
				} catch (JWTDecodeException j) {
					throw new RuntimeException("401");
				}
				SysUser user = userService.findById(userId);
				if (user == null) {
					throw new RuntimeException("用户不存在，请重新登录");
				}

				Map<String, Claim> claims = JwtToken.verifyToken(token);
				Claim user_id_claim = claims.get("user_id");
				if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
					System.out.println("异常");
				}
				return true;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	}
}