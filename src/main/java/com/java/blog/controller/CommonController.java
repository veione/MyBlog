package com.java.blog.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import com.java.blog.entity.Blog;
import com.java.blog.exception.ParamException;
import com.java.blog.service.BlogService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;

/**
 * @author TaoYu
 * @Description 公用方法
 */
@Controller
@RequestMapping("/common")
@Log4j
public class CommonController {
	@Autowired
	private Producer captchaProducer = null;
	@Autowired
	private BlogService blogService;

	@ApiOperation(value = "测试下载Excel", notes = "", response = Blog.class)
	@RequestMapping(value = "/excel")
	public String excel(ModelMap map) throws ParamException, IOException {
		PageInfo<Blog> pageInfo = this.blogService.findByPage(1, 5);
		map.put(NormalExcelConstants.FILE_NAME, "我的博客");
		map.put(NormalExcelConstants.CLASS, Blog.class);
		map.put(NormalExcelConstants.PARAMS, new ExportParams("标题", "表明"));
		map.put(NormalExcelConstants.DATA_LIST, pageInfo.getList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	public static void main(String[] args) {
		String html = "<span>前面           中间          </span>";
		HtmlCompressor compressor = new HtmlCompressor();
		String compress = compressor.compress(html);
		System.out.println(compress);
	}

	/**
	 * @throws IOException
	 * @Describe：生成验证码
	 */
	@RequestMapping("/captcha")
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
		} catch (IOException e) {
			log.error("生成验证码失败");
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

}
