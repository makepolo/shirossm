package com.centurydean.platform.login.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.mysql.jdbc.StringUtils;

/**
 * Author：Galo
 * CreateTime：2015年5月6日 下午3:26:00
 * UpdateBy：Galo
 * UpdateTime：2015年5月6日 下午3:26:00
 * Copyright：CenturyDean.com
 * Description：TODO(简单描述一下该文件功能)
 * Comment：TODO(其它说明)
 */
public class LoginRealm extends AuthorizingRealm{

	/* (non-Javadoc)
	 * 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String currentUsername = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simInfo = new SimpleAuthorizationInfo();
		if(!StringUtils.isNullOrEmpty(currentUsername)){
			simInfo.addStringPermission("user:query");
			return simInfo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * 认证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		AuthenticationInfo authenticationInfo = null;
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = String.valueOf(usernamePasswordToken.getUsername());
		//查询DB找出user信息后判断两个密码是否一致
		//userBo.findByUsername(username)
		String password = new String(usernamePasswordToken.getPassword());
		if("12345".equals(password)){
			authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
			return authenticationInfo;
		}
		return null;
	}

}
