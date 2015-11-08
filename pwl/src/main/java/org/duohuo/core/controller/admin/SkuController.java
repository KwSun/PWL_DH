package org.duohuo.core.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.duohuo.common.web.ResponseUtils;
import org.duohuo.core.bean.product.Sku;
import org.duohuo.core.query.product.SkuQuery;
import org.duohuo.core.service.product.SkuService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存管理
 * @author Kw
 *
 * Date: 2015年11月8日
 */
@Controller
public class SkuController {

	@Autowired
	private SkuService skuService;
	//跳转到库存管理页面
	@RequestMapping(value = "/sku/list.do")
	public String list(Integer productId,String pno ,ModelMap model){
		
		//商品编号回显
		model.addAttribute("pno", pno);
		
		//最小销售单元  通过商品ID
		SkuQuery skuQuery = new SkuQuery();
		skuQuery.setProductId(productId);
		List<Sku> skus = skuService.getSkuList(skuQuery);
		
		//商品编号回显
		model.addAttribute("skus", skus);
		
		return "sku/list";
	}
	//保存和修改
	@RequestMapping(value = "/sku/add.do")
	public void add(Sku sku ,ModelMap model,HttpServletResponse response){
		//修改
		skuService.updateSkuByKey(sku);
		//
		JSONObject jo = new JSONObject();
		jo.put("message", "保存成功!");
		
		ResponseUtils.renderJson(response, jo.toString());
		
	}
}

