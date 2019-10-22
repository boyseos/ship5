package com.ship.web.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ship.web.usr.User;
@Component
public interface UserService {

	public void join(User param);
	public User login(User param);
	public List<User> findAllDept();
	public int countUser();
}
