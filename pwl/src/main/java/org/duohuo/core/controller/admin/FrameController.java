package org.duohuo.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模块body加载
 * @author Kw
 *
 * Date: 2015年10月29日
 */
@Controller
@RequestMapping(value = "/control")
public class FrameController {

	//商品body
	@RequestMapping(value = "/frame/product_main.do")
	public String productMain(){
		
		return "frame/product_main";
	}
	//商品left body
	@RequestMapping(value = "/frame/product_left.do")
	public String productLeft(){
		
		return "frame/product_left";
	}
	//订单body
	@RequestMapping(value = "/frame/order_main.do")
	public String orderMain(){
		
		return "frame/order_main";
	}
	//订单left 
	@RequestMapping(value = "/frame/order_left.do")
	public String orderLeft(){
		
		return "frame/order_left";
	}
}
