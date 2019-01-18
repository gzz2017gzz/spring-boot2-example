package com.gzz.common.config;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.google.common.collect.Lists;
import com.gzz.study.sys.sysuser.SysUser;
import com.gzz.study.sys.sysuser.SysUserService;

@WebFilter(urlPatterns = { "/*" })
public class TokenFilter implements Filter {

	@Autowired
	private SysUserService userService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		List<String> skipList = Lists.newArrayList("/sysUser/login", "/sysUser/logout");// 跳过列表
		if(skipList.contains(request.getRequestURI())) {
			filterChain.doFilter(servletRequest, servletResponse);
		}
		
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
 
		filterChain.doFilter(servletRequest, servletResponse);
 
	}

	@Override
	public void destroy() {

	}
}