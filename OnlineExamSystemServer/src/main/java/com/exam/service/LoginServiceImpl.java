package com.exam.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.RoleDao;
import com.exam.dao.UserDao;
import com.exam.dao.UserRoleDao;
import com.exam.entity.LoginCred;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao u_dao;
	
	@Autowired
	private RoleDao r_dao;
	
	@Autowired
	private UserRoleDao ur_dao;

	@Override
	public String validator(LoginCred lc) {
		
		User local = this.u_dao.findByUsername(lc.getUsername());
		System.out.println(local.getUsername());
		System.out.println(local.getPassword());
		System.out.println(lc.getUsername());
		System.out.println(lc.getPassword());
		
		UserRole urole = ur_dao.getReferenceById(local.getId());
		Set<UserRole> userRoleSet = local.getUserRoles();
		Role r = new Role();
		for(UserRole u:userRoleSet) {
			r = u.getRole();
		}
		System.out.println(r.getRoleName());
		
		
		//System.out.println("Role Id : "+this.ur_dao.findById(12));
		
		
		if(local!=null && lc.getPassword().equals(local.getPassword())) { 
			return "true";
		}
		return "false";
	}

	@Override
	public User getUser(String username) {
		User local = this.u_dao.findByUsername(username);
		return local;
	}
	
	

	

}
