package com.java.blog.service;

import com.baomidou.framework.service.ISuperService;
import com.github.pagehelper.PageInfo;
import com.java.blog.entity.Blog;
import com.java.blog.page.ParamPage;

public interface BlogService extends ISuperService<Blog>  {


	PageInfo<Blog> findByPage(ParamPage paramPage);

	PageInfo<Blog> findByPageAndType(Integer pageNum, Integer pageSize, Integer id);
	

}
