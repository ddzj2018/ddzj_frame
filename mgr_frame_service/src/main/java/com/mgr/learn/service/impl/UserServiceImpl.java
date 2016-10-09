package com.mgr.learn.service.impl;

import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.learn.api.IUserService;
import com.mgr.learn.dao.mapper.IUserMapper;
import com.mgr.learn.domain.User;

@Service
public class UserServiceImpl implements IUserService {
	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	@Autowired(required = false)
	private IUserMapper iUserMapper;

	public int insert(User user) {
		int result = 0;
		try {
			iUserMapper.insert(user);
			result = 1;
		} catch (Exception e) {
			log.error("==insert user exception:" + e);
		}
		return result;
	}

	public int del(int id) {
		int result = 0;
		try {
			iUserMapper.del(id);
			result = 1;
		} catch (Exception e) {
			log.error("==del user exception:" + e);
		}
		return result;
	}

	public int update(User user) {
		int result = 0;
		try {
			iUserMapper.update(user);
			result = 1;
		} catch (Exception e) {
			log.error("==update user exception:" + e);
		}
		return result;
	}

	public User getUserById(int id) {
		try {
			return iUserMapper.getUserById(id);
		} catch (Exception e) {
			log.error("==getUserById exception:" + e);
		}
		return null;
	}

	public User getUserByUserName(String userName) {
		try {
			return iUserMapper.getUserByUserName(userName);
		} catch (Exception e) {
			log.error("==getUserByUserName exception:" + e);
		}
		return null;
	}

	public List<User> find(int pageNum, int pageSize) {
		HashedMap param = new HashedMap();
		param.put("pageIndex", (pageNum - 1) * pageSize);
		param.put("pageSize", pageSize);
		try {
			return iUserMapper.find(param);
		} catch (Exception e) {
			log.error("==find exception:" + e);
		}
		return null;
	}

	public int count() {
		HashedMap param = new HashedMap();
		try {
			return iUserMapper.count(param);
		} catch (Exception e) {
			log.error("==count exception:" + e);
		}
		return 0;
	}

}
