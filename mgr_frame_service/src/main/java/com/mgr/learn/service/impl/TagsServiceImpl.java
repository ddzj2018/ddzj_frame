package com.mgr.learn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.learn.api.ITagsService;
import com.mgr.learn.dao.ITagsDao;
import com.mgr.learn.domain.Tags;
import com.mgr.learn.domain.dbtype.DataSourceType;


@Service
public class TagsServiceImpl implements ITagsService{
	
	@Autowired(required = false)
	private ITagsDao tagsDaoImpl;
	/**
	 * 分页查询tags
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Tags> find(int pageNum,int pageSize) {
		return tagsDaoImpl.find(pageNum, pageSize, Tags.class, "tags", DataSourceType.USER_MASTER);
	}
}
