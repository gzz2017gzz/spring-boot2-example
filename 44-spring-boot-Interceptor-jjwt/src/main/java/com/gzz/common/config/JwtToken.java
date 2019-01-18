package com.gzz.common.config;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * APP登录Token的生成和解析
 * 
 */
public class JwtToken {

	public static final String SECRET = "gzz_gzz@163.com";
	/** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
	public static final int calendarField = Calendar.DATE;
	public static final int calendarInterval = 10;

	/** token 过期时间: 10天 */

	/**
	 * JWT生成Token.<br/>
	 * 
	 * JWT构成: header, payload, signature
	 * 
	 * @param user_id 登录成功后用户user_id, 参数user_id不可传空
	 */
	public static String createToken(Long user_id) {
		Date iatDate = new Date();
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(calendarField, calendarInterval);
		Date expiresDate = nowTime.getTime();
		Map<String, Object> map = new HashMap<>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");

		String token = JWT.create().withHeader(map)
				.withClaim("iss", "Service") // payload
				.withClaim("aud", "APP")
				.withClaim("user_id", user_id.toString())
				.withIssuedAt(iatDate) // sign time
				.withExpiresAt(expiresDate) // expire time
				.sign(Algorithm.HMAC256(SECRET)); // signature

		return token;
	}

	/**
	 * 解密Token
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Claim> verifyToken(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
		DecodedJWT jwt = verifier.verify(token);
		return jwt.getClaims();
	}

	/**
	 * 根据Token获取user_id
	 * 
	 * @param token
	 * @return user_id
	 */
	public static Long getAppUID(String token) {
		Map<String, Claim> claims = verifyToken(token);
		Claim user_id_claim = claims.get("user_id");
		if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
			System.out.println("异常");
		}
		return Long.valueOf(user_id_claim.asString());
	}

	public static void main(String[] args) {
		System.out.println(createToken(1L));
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJ1c2VyX2lkIjoiMSIsImlzcyI6IlNlcnZpY2UiLCJleHAiOjE1NDgzMTI1NDYsImlhdCI6MTU0NzQ0ODU0Nn0.ujCaaZuYPRPp_5RxtZMzAnLokMgEOpsja4x8IlSwKH8";
		System.out.println(getAppUID(token));
	}

}
