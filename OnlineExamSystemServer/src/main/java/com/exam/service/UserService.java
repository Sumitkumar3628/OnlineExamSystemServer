package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserAlreadyPresent;

public interface UserService {
	
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws UserAlreadyPresent;
	public User getUser(String username);
	//delete user by id
	public void deleteUser(int userId);

}
