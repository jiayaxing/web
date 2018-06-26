package com.jiayaxing.web.config.shiro;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiayaxing.web.service.UserService;

public class MyShiroRealm extends AuthorizingRealm{
	@Autowired
	UserService userService;

	//角色权限和对应权限添加
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		
		String username = (String)principalCollection.getPrimaryPrincipal();
		Set<String> permissions = new HashSet<>();
		Set<String> roles = new HashSet<>();
		roles = userService.getRolesByUsername(username);
		permissions = userService.getPermsByUsername(username);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		info.addRoles(roles);
		System.out.println("数据库验证权限");
		return info;
	}

	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username = (String)authenticationToken.getPrincipal();
		
		Map<String,Object> map = userService.getUserInfoByUsername(username);
		
		String password = map.get("password").toString();
		/*if (loginUser.isDisabled()) {
            throw new DisabledAccountException();
        }*/
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,ByteSource.Util.bytes("yanzhi"),getName());//将用户名、密码、盐和Realm名称封装到这个对象中。
		return info;//将这个对象返回给Shiro,Shiro就会帮我们进行对应的验证和缓存。
	}

}
