package com.gzz.common.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TokenInterceptor implements HandlerInterceptor {
	@Autowired
	private SysUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object object) throws Exception {
		String token = request.getHeader("token");// 从 http 请求头中取出 token
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

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	}
}