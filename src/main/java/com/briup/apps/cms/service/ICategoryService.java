package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;

public interface ICategoryService {
	
	List<Category> findAll();
	
	void saveOrUpdate(Category category);
	
	Category findById(long id);
	
	void deleteById(long id);
	
	void branchDel(long[] ids); 
	
}
