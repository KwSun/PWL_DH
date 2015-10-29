package org.duohuo.core.controller.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
@RequestMapping(value="/control")
public class CenterController {
	
	@RequestMapping(value = "/test/springmvc.do")
	public String test(String name,Date birthday){
		
		System.out.println();
		return "";
	}
	
	//跳转入口页面
		@RequestMapping(value = "/index.do")
		public String index(){
			return "index";
		}
		//跳转头页面
		@RequestMapping(value = "/top.do")
		public String top(){
			return "top";
		}
		//跳转身体页面
		@RequestMapping(value = "/main.do")
		public String main(){
			return "main";
		}
		//跳转左页面
		@RequestMapping(value = "/left.do")
		public String left(){
			return "left";
		}
		//跳转右页面
		@RequestMapping(value = "/right.do")
		public String right(){
			return "right";
		}
		

	}