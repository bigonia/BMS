package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class CategoryServiceImpl implements ICategoryService{

	@Resource
	private CategoryMapper categoryMapper;
	
	
	@Override
	public List<Category> findAll() {
		List<Category> list = categoryMapper.selectByExample(new CategoryExample());
		return list;
	}

	@Override
	public void saveOrUpdate(Category category) {
		if(category.getId()!=null) {
			//update
			int i = categoryMapper.updateByPrimaryKey(category);
			if(i==0) {
				throw new CustomerException("更新失败");
			}
		}else {
			//save
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("category已存在");
			}
			categoryMapper.insert(category);
		}
	}

	@Override
	public Category findById(long id) {
		Category category = categoryMapper.selectByPrimaryKey(id);
		return category;
	}

	@Override
	public void deleteById(long id) {
		int i = categoryMapper.deleteByPrimaryKey(id);
		if(i==0) {
			throw new CustomerException("删除失败");
		}
	}

	@Override
	public void branchDel(long[] ids) {
		for (long id : ids) {
			int i = categoryMapper.deleteByPrimaryKey(id);
			if(i==0) {
				throw new CustomerException("删除失败");
			}
		}
	}

}
