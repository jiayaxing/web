package com.jiayaxing.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiayaxing.web.service.EhCacheService;



@RestController
@RequestMapping("registerController")
public class RegisterController {
	private static Logger log = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	EhCacheService ehCacheService;
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public Map<String,Object> register(@RequestParam String username,@RequestParam String password){
		Map<String,Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		Md5Hash hash = new Md5Hash(password, "yanzhi", 3);
		System.out.println(hash.toString());
		log.info(username+":"+password);
		return map;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Map<String,Object> login(@RequestParam String username,@RequestParam String password){
		Map<String,Object> map = new HashMap<>();
		AtomicInteger passwordRetryTimes = ehCacheService.getPasswordRetryCache(username);
		if(passwordRetryTimes != null && passwordRetryTimes.get() > 2) {//第三次弹出多次错误，第四次开始校验验证码是否正确
			//校验验证码是否正确，正确则通过继续后续校验，不正确则直接返回不用校验后续校验。
			System.out.println("校验验证码");
		}
		System.out.println(passwordRetryTimes);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		try {
			subject.login(usernamePasswordToken);
			map.put("token", subject.getSession().getId());
			map.put("msg",  "登录成功");
		}catch (UnknownAccountException e) {
			map.put("msg",  "账号或密码错误");//没找到帐号
		}catch (IncorrectCredentialsException  e) {
			map.put("msg",  "账号或密码错误");//密码错误
		}catch (LockedAccountException e) {
			map.put("msg",  "用户已被冻结");//用户已被冻结
		}catch (ExcessiveAttemptsException e) {
			map.put("msg",  "账号或密码错误次数太多，为了您的账户安全，账户被锁定十分钟。");//
		}catch (AuthenticationException e) {
			map.put("msg",  "账号或密码错误");//其他认证失败如ExpiredCredentialsException 凭证过期、ConcurrentAccessException 并发访问异常（多个用户同时登录时抛出）、UnsupportedTokenException 使用了不支持的Token
		}catch (Exception e) {
			map.put("msg",  "登录发生了错误");//发生了普通运行时异常
			log.error("错误信息",e);
		}
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
