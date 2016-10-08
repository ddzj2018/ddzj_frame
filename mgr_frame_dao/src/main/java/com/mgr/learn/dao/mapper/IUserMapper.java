package com.mgr.learn.dao.mapper;

import java.util.List;
import org.apache.commons.collections.map.HashedMap;
import com.mgr.learn.domain.User;

/**
 * 用户mapper
 * 
 * @author zhouchangwei
 * @date 2015年7月22日
 *
 */
public interface IUserMapper {
	
	public int insert(User user);
	
	public int del(int id);
	
	public int update(User user);
	
	public User getUserById(int id);
	
	public User getUserByUserName(String userName);
	
	public List<User> find(HashedMap param);
	
	public int count(HashedMap param);
	
}
