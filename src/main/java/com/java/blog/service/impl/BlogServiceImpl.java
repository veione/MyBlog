package com.java.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.blog.entity.Blog;
import com.java.blog.mapper.BlogMapper;
import com.java.blog.page.ParamPage;
import com.java.blog.service.BlogService;

@Service
public class BlogServiceImpl extends SuperServiceImpl<BlogMapper, Blog> implements BlogService {

	@Resource
	private BlogMapper blogMapper;

	@Override
	/* @Cacheable(cacheNames = "blog", key = "#paramPage") */
	public PageInfo<Blog> findByPage(ParamPage paramPage) {
		PageHelper.startPage(paramPage.getPageNum(), paramPage.getPageSize());
		List<Blog> list = blogMapper.selectList(new EntityWrapper<Blog>(null));
		PageInfo<Blog> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Blog> findByPageAndType(ParamPage paramPage, Integer id) {
		PageHelper.startPage(paramPage.getPageNum(), paramPage.getPageSize());
		Blog blog = new Blog();
		if (id != -1) {
			blog.setTypeId(id);
		}
		List<Blog> list = blogMapper.selectList(new EntityWrapper<Blog>(blog));
		PageInfo<Blog> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
