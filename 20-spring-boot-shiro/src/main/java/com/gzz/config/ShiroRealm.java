package com.gzz.config;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gzz.sys.rolefunction.RoleFunctionDao;
import com.gzz.sys.user.User;
import com.gzz.sys.user.UserCond;
import com.gzz.sys.user.UserDao;
import com.gzz.sys.userrole.UserRoleDao;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
	private final Log logger = LogFactory.getLog(ShiroRealm.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleFunctionDao rolePermissionDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = (User) principals.getPrimaryPrincipal();
		Set<String> queryRoles = userRoleDao.queryRoles(user.getId());
		logger.info(queryRoles);
		authorizationInfo.setRoles(queryRoles);
		Set<String> queryPermissions = rolePermissionDao.queryPermissions(user.getId());
		logger.info(queryPermissions);
		authorizationInfo.setStringPermissions(queryPermissions);
		return authorizationInfo;
	}

	/* 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name = (String) token.getPrincipal();
		List<User> users = userDao.queryList(UserCond.builder().name(name).build());
		if (users.size() == 0) {
			return null;
		}
		User user = users.get(0);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
				ByteSource.Util.bytes(user.getName() + user.getSalt()), getName());
		return authenticationInfo;
	}

//生成密码工具
	public static void main(String[] args) {
		DefaultHashService hashService = new DefaultHashService();
		HashRequest request = new HashRequest.Builder().setAlgorithmName("md5")
				.setSource(ByteSource.Util.bytes("123456"))
				.setSalt(ByteSource.Util.bytes("zhangb5b96ddcbba29359b13386082a45d4fe")).setIterations(2).build();
		String hex = hashService.computeHash(request).toHex();
		System.out.println(hex);
	}
}