package com.java.blog.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.java.blog.entity.Comment;
import com.java.blog.mapper.CommentMapper;
import com.java.blog.service.CommentService;

/**
 *
 * Comment 表数据服务层接口实现类
 *
 */
@Service
public class CommentServiceImpl extends SuperServiceImpl<CommentMapper, Comment> implements CommentService {


}