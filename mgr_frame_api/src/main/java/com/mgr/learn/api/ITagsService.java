package com.mgr.learn.api;

import java.util.List;

import com.mgr.learn.domain.Tags;

public interface ITagsService {
	
	public List<Tags> find(int pageNum,int pageSize);
	
}
