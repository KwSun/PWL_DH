package org.duohuo.core.controller;



import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.duohuo.common.encode.Md5Pwd;
import org.duohuo.common.web.session.SessionProvider;
import org.duohuo.core.bean.user.Buyer;
import org.duohuo.core.service.user.BuyerService;
import org.duohuo.core.web.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 
 * @author Kw
 *
 * Date: 2015年11月10日
 */
@Controller
public class ProfileController {
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private Md5Pwd md5Pwd;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private ImageCaptchaService imageCaptchaService;

	//GET
	@RequestMapping(value = "/shopping/login.shtml",method=RequestMethod.GET)
	public String login(){
		return "buyer/login";
	}
	
	//POST
		/**
		 * 1:验证码是否为null
			2:验证码  是否正确
			3:用户是否为NUll
			4:密码是否为NUll
			5:用户是否正确
			6密码是否正确
			Md5  纯生Md5 
			放进Session   跳转ReturnUrl
		 * @param buyer
		 * @param captcha
		 * @param returnUrl
		 * @return
		 */
		@RequestMapping(value = "/shopping/login.shtml",method=RequestMethod.POST)
		public String login(Buyer buyer,String captcha,String returnUrl,ModelMap model,HttpServletRequest request){
			//验证码是否为null
			if(StringUtils.isNotBlank(captcha)){
				//1:JSESSIONID
				//2验证码
				if(imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request), captcha)){
					if(null != buyer && StringUtils.isNotBlank(buyer.getUsername())){
						if(StringUtils.isNotBlank(buyer.getPassword())){
							Buyer b = buyerService.getBuyerByKey(buyer.getUsername());
							if(null != b){
								//
								if(b.getPassword().equals(md5Pwd.encode(buyer.getPassword()))){
									//把用户对象放在Session
									sessionProvider.setAttribute(request, Constants.BUYER_SESSION, b);
									if(StringUtils.isNotBlank(returnUrl)){
										return "redirect:" + returnUrl;
									}else{
										//个人中心
										return "redirect:/buyer/index.shtml" ;
									}
								}else{
									model.addAttribute("error", "密码错误");
								}
							}else{
								model.addAttribute("error", "用户名输入错误");
							}
						}else{
							model.addAttribute("error", "请输入密码");
						}
					}else{
						model.addAttribute("error", "请输入用户名");
					}
				}else{
					model.addAttribute("error", "验证码输入错误");
				}
			}else{
				model.addAttribute("error", "请填写验证码");
			}
			return "buyer/login";
		}
		//个人中心
		@RequestMapping(value = "/buyer/index.shtml")
		public String index(){
			return "buyer/index";
		}
		
}