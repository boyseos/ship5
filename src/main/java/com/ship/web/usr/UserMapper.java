package com.ship.web.usr;

import java.util.List;
import com.ship.web.usr.User;

import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
	public void insertUser(User user);
	public User selectUserById(User user);
	public List<User> findByDeptTable();
	public int countUser();
}
