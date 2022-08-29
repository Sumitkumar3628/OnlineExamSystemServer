package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserAlreadyPresent;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws UserAlreadyPresent {
		
		Role role=new Role();
		role.setRoleId(55);
		role.setRoleName("STUDENT"); //demo code to see the working
		
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(user);
		
		
		Set<UserRole> roles=new HashSet<>();
		roles.add(userrole);
		
		return this.uService.createUser(user, roles);
		
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username) {
		return this.uService.getUser(username);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id")int id) {
		this.uService.deleteUser(id);
	}

}
