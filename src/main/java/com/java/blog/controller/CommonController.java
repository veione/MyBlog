package com.java.blog.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import lombok.extern.log4j.Log4j;
import springfox.documentation.annotations.ApiIgnore;

/**@author TaoYu
 * @Description 主控制器，简化跳转
 */
@Controller
@ApiIgnore
@RequestMapping("/common")
@Log4j
public class CommonController {
	@Autowired
	private Producer captchaProducer = null;

	/**@throws IOException 
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
