package com.java.blog.service;

import java.util.List;

import com.baomidou.framework.service.ISuperService;
import com.java.blog.entity.BlogType;


public interface BlogTypeService extends ISuperService<BlogType> {

	/**
	 * @Describe:查找所有类型
	 */
	List<BlogType> getAllBlogTypes();


}