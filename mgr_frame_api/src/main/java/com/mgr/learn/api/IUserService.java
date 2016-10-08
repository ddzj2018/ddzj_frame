package com.mgr.learn.api;

import java.util.List;

import com.mgr.learn.domain.User;



public interface IUserService {
	
	public int insert(User user);
	
	public int del(int id);
	
	public int update(User user);
	
	public User getUserById(int id);
	
	public User getUserByUserName(String userName);
	
	public List<User> find(int pageNum,int pageSize);
	
	public int count();
}
