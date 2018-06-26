package com.jiayaxing.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jiayaxing.web.dao.ShiroRolePermissonMapper;
import com.jiayaxing.web.dao.ShiroUserMapper;
import com.jiayaxing.web.dao.ShiroUserRoleMapper;
import com.jiayaxing.web.model.ShiroUser;

@Service("userService")
public class UserService {
	
	@Autowired
	ShiroUserMapper shiroUserMapper;
	@Autowired
	ShiroUserRoleMapper shiroUserRoleMapper;
	@Autowired
	ShiroRolePermissonMapper shiroRolePermissonMapper;
	
	public Map<String,Object> getUserInfoByUsername(String name) {
		Map<String,Object>  map = shiroUserMapper.getUserInfoByUsername(name);
		return map;
	}
	
	public Set<String> getRolesByUsername(String name) {
		Set<String> list = shiroUserRoleMapper.getRolesByUsername(name);
		return list;
	}
	
	public Set<String> getPermsByUsername(String name) {
		Set<String> list = shiroRolePermissonMapper.getPermsByUsername(name);
		return list;
	}
	
	@Cacheable(value = "shiroUser", key = "#id")
	public ShiroUser getUserInfo(int id){
		System.out.println("数据库查询");
		ShiroUser shiroUser = shiroUserMapper.selectByPrimaryKey(id);
		return shiroUser;
	}
}
