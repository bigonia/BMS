package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//@Api(tags="文章接口")
@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@ApiOperation("查询全部文章")
	@GetMapping("/findAll")
	public Message findAll(){
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
	}
	
	@ApiOperation("查询文章及其分类")
	@GetMapping("/findAllWithCategory")
	public Message findAllWithCategory(){
		List<ArticleExtend> list = articleService.findAllWithCategory();
		return MessageUtil.success(list);
	}
	
	@ApiOperation("保存或更新")
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(
			@ApiParam(value = "文章编号")@RequestParam(value = "id",required = false)Long id,
			@ApiParam(value = "文章标题",required = true)@RequestParam(value = "title")String title,
			@ApiParam(value = "文章内容",required = true)@RequestParam("content")String content,
			@ApiParam(value = "文章source",required = true)@RequestParam(value = "source", required = false)String source,
			@ApiParam(value = "作者ID",required = true)@RequestParam("authorId")long authorId,
			@ApiParam(value = "类别ID",required = true)@RequestParam("categoryId")long categoryId){
		
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setAuthorId(authorId);
		article.setCategoryId(categoryId);
		articleService.saveOrUpdate(article);
		return MessageUtil.success("提交成功！");
	}
	
	@ApiOperation("删除指定文章")
	@GetMapping("/deleteById")
	public Message deleteById(
			@ApiParam("文章id")@RequestParam("id")Long id) {
		
		articleService.deleteById(id);
		return MessageUtil.success("删除成功！");
	}
	
}
