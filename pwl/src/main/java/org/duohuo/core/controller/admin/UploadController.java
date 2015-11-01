package org.duohuo.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.duohuo.common.web.ResponseUtils;
import org.duohuo.core.web.Constants;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 上传图片
 * 商品
 * 品牌
 * 商品介绍Fck
 * @author Kw
 *
 * Date: 2015年10月29日
 */
@Controller
public class UploadController {
	
	//上传图片
	@RequestMapping(value = "/upload/uploadPic.do")
	//异步，SpringMVC不需要返回值;用HttpServletResponse返回路径
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,HttpServletResponse response){
		//extension of the pic，扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//the way to create pic name
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//one part of the pic name
		String format = df.format(new Date());
		
		//random three-digit number three figures
		Random r = new Random();
		// n 1000   0-999   99
		for(int i=0 ; i<3 ;i++){
			format += r.nextInt(10);
		}
		
		//instantiation
		Client client = new Client();
		//save to the database，相对路径
		String path = "upload/" + format + "." + ext;
		
		//another tomcat path
		String url = Constants.IMAGE_URL  + path;
		//set the requiring path
		WebResource resource = client.resource(url);
		
		//start to send(put way)
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return the two paths,the basement of JSONObject  is map,拼接字符串
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path",path);
		
		ResponseUtils.renderJson(response, jo.toString());
	}

}
