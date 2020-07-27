package com.mary.blog.repository;

import java.util.List;

import com.mary.blog.model.User;

public interface UserRepository {
	public void save(User user);
	public User login(User user);
}



