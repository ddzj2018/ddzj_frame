package com.mgr.learn.dao.impl;

import org.springframework.stereotype.Repository;

import com.mgr.learn.dao.ITagsDao;
import com.mgr.learn.domain.Tags;




/**
 * 通用mongo操作接口实现类
 * @author zhouchangwei
 *
 * @param <T>
 */
@Repository
public class TagsDaoImpl extends GeneralDaoImpl<Tags> implements ITagsDao{
	
}
