package com.java.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.blog.dao.BlogDao;
import com.java.blog.entity.Blog;
import com.java.blog.page.ParamPage;
import com.java.blog.service.BlogService;

@Service
public class BlogServiceImpl extends SuperServiceImpl<BlogDao, Blog> implements BlogService {

	@Resource
	private BlogDao blogDao;

	@Override
	@Cacheable(cacheNames = "blog", key = "#paramPage")
	public PageInfo<Blog> findByPage(ParamPage paramPage) {
		PageHelper.startPage(paramPage.getPageNum(), paramPage.getPageSize());
		List<Blog> list = blogDao.selectList(new EntityWrapper<Blog>(null));
		PageInfo<Blog> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Blog> findByPageAndType(Integer pageNum, Integer pageSize, Integer id) {
		PageHelper.startPage(pageNum, pageSize);
		Blog blog = new Blog();
		blog.setTypeId(id);
		List<Blog> list = blogDao.selectList(new EntityWrapper<Blog>(blog));
		PageInfo<Blog> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
