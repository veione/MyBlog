package com.java.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.blog.entity.BlogType;
import com.java.blog.exception.ParamException;
import com.java.blog.service.BlogTypeService;
import com.java.blog.utils.ResponseJson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("blogType-api")
@RestController
@RequestMapping("/blogType")
public class BlogTypeController {

	@Autowired
	private BlogTypeService blogTypeService;

	@ApiOperation(value = "类型", notes = "所有类型", response = BlogType.class)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseJson all() throws ParamException {
		ResponseJson json = new ResponseJson();
		List<BlogType> types = blogTypeService.selectList(new BlogType());
		json.setResults(types);
		return json;
	}

}
