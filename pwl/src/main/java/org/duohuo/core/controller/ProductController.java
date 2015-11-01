package org.duohuo.core.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台测试
 * @author Kw
 *
 * Date: 2015年10月28日
 */
@Controller
public class ProductController {
	@RequestMapping(value = "/test/springmvc.do")
	public String test(String name,Date birthday){
		
		System.out.println();
		return "";
	}
}
