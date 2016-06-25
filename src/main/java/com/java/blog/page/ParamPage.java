
package com.java.blog.page;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author TaoYu
 * @Description 如果以对象形式上传分页信息用这个
 */
@ApiModel("上传分页")
@Setter
@Getter
public class ParamPage implements Serializable {

	private static final long serialVersionUID = 4400465065502807974L;

	private final static int DEFAULT_PAGE_NUM = 1;

	private final static int DEFAULT_PAGE_SIZE = 5;

	private Integer pageNum;

	private Integer pageSize;

	public ParamPage() {
		this.pageNum = DEFAULT_PAGE_NUM;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	public ParamPage(Integer pageNum, Integer pageSize) {
		if (pageNum == null || pageNum < 1) {
			this.pageNum = DEFAULT_PAGE_NUM;
		} else {
			this.pageNum = pageNum;
		}
		if (pageSize == null || pageSize < 1) {
			this.pageSize = DEFAULT_PAGE_SIZE;
		} else {
			this.pageSize = pageSize;
		}
	}

}