package com.jiayaxing.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("registerController")
public class RegisterController {
	private static Logger log = LoggerFactory.getLogger(RegisterController.class);
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public Map<String,Object> register(@RequestParam String username,@RequestParam String password) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		Md5Hash hash = new Md5Hash(password, "yanzhi", 3);
		System.out.println(hash.toString());
		log.info(username+":"+password);
		return map;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Map<String,Object> login(@RequestParam String username,@RequestParam String password) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

		subject.login(usernamePasswordToken);
		map.put("token", subject.getSession().getId());
		map.put("msg",  "登录成功");

		log.info(map.toString());
		return map;
	}
	
	@RequestMapping(value="returnLogin",method=RequestMethod.GET)
	public Map<String,Object> returnLogin(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg", "没有登录");
		log.info(map.toString());
		return map;
	}
	
	@RequestMapping(value="unauthorized",method=RequestMethod.GET)
	public Map<String,Object> unauthorized(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg", "权限不足，验证失败");
		log.info(map.toString());
		return map;
	}
	
	@RequestMapping(value="logout1",method=RequestMethod.GET)
	public Map<String,Object> logout(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg", "退出登录");
		log.info(map.toString());
		return map;
	}


}
