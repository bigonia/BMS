package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@Api(tags= {"category接口",""})
@RestController()
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@ApiOperation("查询全部category")
	@PostMapping("/findAll")
	public Message findAll() {
		List<Category> list = categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@ApiOperation("保存或更新")
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(Category category) {
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("提交成功！");
	}
	
	@ApiOperation("按id查找")
	@PostMapping("/findById")
	public Message findById(Long id) {
		Category category = categoryService.findById(id);
		return MessageUtil.success(category);
	}
	
	@ApiOperation("按id删除")
	@GetMapping("/deleteById")
	public Message deleteById(Long id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功！");
	}
	
	@ApiOperation("批量删除")
	@PostMapping("/batchDelete")
	public Message batchDelete(long[] ids) {
		categoryService.branchDel(ids);
		return MessageUtil.success("删除成功！");
	}
	
}
