package com.java.blog.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.java.blog.dao.BlogTypeDao;
import com.java.blog.entity.BlogType;
import com.java.blog.service.BlogTypeService;

@Service
public class BlogTypeServiceImpl extends SuperServiceImpl<BlogTypeDao, BlogType> implements BlogTypeService {

}
