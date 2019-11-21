package com.briup.apps.cms.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.service.ITestService;
import com.briup.apps.cms.service.impl.TestServiceImpl;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private ITestService testService;
	
	@GetMapping("/getAll")
	public List<Test> getAllUser(){
		
		List<Test> list = testService.findAll();
		return list;
		
	}
	
	@PostMapping("/updateUser")
	public String updateUser(Test test) {
		
		testService.saveOrUpdate(test);
		return "更新成功！";
		
	}
	
}
