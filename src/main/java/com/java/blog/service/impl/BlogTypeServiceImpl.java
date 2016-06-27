package com.java.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.java.blog.entity.BlogType;
import com.java.blog.mapper.BlogTypeMapper;
import com.java.blog.service.BlogTypeService;

@Service
public class BlogTypeServiceImpl extends SuperServiceImpl<BlogTypeMapper, BlogType> implements BlogTypeService {

	@Override
	public List<BlogType> getAllBlogTypes() {
	/*	String redisTypes = RedisUtils.get("blogTypes");
		if (redisTypes != null) {
			return (List<BlogType>) JSON.parse(redisTypes);
		} else {
			List<BlogType> typesReal = this.selectList(new BlogType());
			RedisUtils.set("blogTypes", JSON.toJSONString(typesReal));
			return typesReal;
		}*/
		return  this.selectList(new BlogType());
	}

}
