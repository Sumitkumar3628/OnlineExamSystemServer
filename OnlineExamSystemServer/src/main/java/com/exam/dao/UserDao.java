package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
