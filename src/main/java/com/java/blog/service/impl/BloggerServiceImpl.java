package com.java.blog.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.java.blog.entity.Blogger;
import com.java.blog.mapper.BloggerMapper;
import com.java.blog.service.BloggerService;

/**
 *
 * Blogger 表数据服务层接口实现类
 *
 */
@Service
public class BloggerServiceImpl extends SuperServiceImpl<BloggerMapper, Blogger> implements BloggerService {


}