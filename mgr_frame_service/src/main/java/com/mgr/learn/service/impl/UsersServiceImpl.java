package com.mgr.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.learn.api.IUsersService;
import com.mgr.learn.dao.mapper.IUsersMapper;



@Service
public class UsersServiceImpl implements IUsersService {
	@Autowired(required = false)
	private IUsersMapper iUsersMapper;

	public String getPinCreateTime(String pin) {
		return iUsersMapper.getPinCreateTime(pin);
	}
	
}
