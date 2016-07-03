package com.java.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.blog.service.BlogService;

import io.swagger.annotations.Api;

@Api("后台控制层")
@RequestMapping("/admin")
@Controller
public class BackController {

	@Autowired
	private BlogService blogService;

	/**
	 * @Describe:跳转到首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}
