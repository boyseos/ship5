package com.ship.web.usr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.cmm.IConsumer;
import com.ship.web.cmm.IFunction;
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/users/**")

public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired User user;
	@Autowired Printer printer;
	@Autowired UserMapper userMapper;
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User user) {
		logger.info("조인 아이디{}",user.getUid() +", "+user.getUpw());
//		new IConsumer() {
//			@Override
//			public void accept(Object o) {
//				userMapper.insertUser(user);
//			}
//		};
		//IConsumer<User> xx = x -> userMapper.insertUser(x);
		//xx.accept(user);
		System.out.println("");
		Map<String,String> map = new HashMap<>();
		map.put("xxx","가입성공");
		return map;
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User param) {
		logger.info("AJAX 가 보낸 아이디{}",param.getUid() +", "+param.getUpw());
//		return (new IFunction() {			
//			@Override
//			public Object apply(Object o) {
//				return userMapper.selectUserById(param);
//			}}).apply(param);
		//IFunction U = ((x) -> userMapper.selectUserById((User) x));
		IFunction<User,User> xx = x -> userMapper.selectUserById(x);
		IConsumer<String> xy = x -> System.out.println(x);
		xy.accept("abdc");
		return param;
	}
}
