package com.briup.apps.cms.bean.extend;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;

@SuppressWarnings("unused")
public class ArticleExtend extends Article{
	
	public static final String NOT_CHECKED = "未审核";
	public static final String CHECKED_PASS = "审核通过";
	public static final String CHECKED_NOTPASS = "审核未通过";
	
	private Category category;
	
//	private String author;
	
//	private List<Comment> comments;
	
//	private User user;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
