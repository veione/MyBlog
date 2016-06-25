package com.java.blog.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel("博客分词对象")
public class LuceneBlog implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	@ApiModelProperty("主键")
	private Integer id;

	@ApiModelProperty("博客标题")
	private String title;

	@ApiModelProperty("博客内容")
	private String content;

	@ApiModelProperty("发布日期")
	private String releaseDate;

}
