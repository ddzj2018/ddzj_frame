package com.mgr.learn.dao.mapper;


/**
 * 用户mapper
 * 
 * @author zhouchangwei
 * @date 2015年7月22日
 *
 */
public interface IUsersMapper {
	/**
	 * 根据pin查询pin的创建时间
	 * @param pin
	 * @return
	 */
	public String getPinCreateTime(String pin);

}
