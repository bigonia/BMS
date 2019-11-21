package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	@Override
	public List<Article> findAll() {
		List<Article> list = articleMapper.selectByExample(new ArticleExample());
		return list;
	}

	@Override
	public List<ArticleExtend> findAllWithCategory() {
		List<ArticleExtend> list = articleExtendMapper.selectAllwithCategory();
		return list;
	}

	@Override
	public void saveOrUpdate(Article article) {
		if(article.getId()!=null) {
//			articleMapper.updateByExample(article, new ArticleExample());
			articleMapper.updateByPrimaryKey(article);
		}else {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("文章标题已存在");
			}
			article.setPublishTime(new Date().getTime());
			article.setStatus(ArticleExtend.NOT_CHECKED);
			article.setReadTimes(0l);
			article.setThumpUp(0l);
			article.setThumpDown(0l);
			articleMapper.insert(article);
		}
	}

	@Override
	public Article findById(long id) {
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article==null) {
			throw new CustomerException("文章id不存在");
		}
		return article;
		
	}

	@Override
	public void deleteById(long id) {
		int i = articleMapper.deleteByPrimaryKey(id);
		if(i==0) {
			throw new CustomerException("删除失败");
		}
	}

	/*
	 * @Override public List<ArticleExtend> findAllWithAuthor() {
	 * 
	 * return null; }
	 */
		
	
}
