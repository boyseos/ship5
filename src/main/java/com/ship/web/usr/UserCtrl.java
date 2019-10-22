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

import com.ship.web.usr.User;
import com.ship.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/users")
@Log4j
public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired User user;
	@Autowired Printer printer;
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User param) {
		logger.info("조인 아이디{}",param.getUid() +", "+param.getUpw());
		printer.accept("람다 조인 아이디 "+param.getUid() + ", "+param.getUpw());
		Map<String,String> map = new HashMap<>();
		map.put("uid",param.getUid());
		map.put("upw",param.getUpw());
		logger.info("맵에 담긴 아이디와 비번{}",map.get("uid")+","+map.get("upw"));
		return map;
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User param) {
		logger.info("AJAX 가 보낸 아이디{}",param.getUid() +", "+param.getUpw());
//		user = userService.login(param);
//		logger.info("사용자 정보{}",userService.login(param).toString());
		return user;
	}
}
