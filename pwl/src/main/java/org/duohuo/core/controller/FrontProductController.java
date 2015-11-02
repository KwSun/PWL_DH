package org.duohuo.core.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Brand;
import org.duohuo.core.bean.product.Feature;
import org.duohuo.core.bean.product.Product;
import org.duohuo.core.bean.product.Type;
import org.duohuo.core.query.product.BrandQuery;
import org.duohuo.core.query.product.FeatureQuery;
import org.duohuo.core.query.product.ProductQuery;
import org.duohuo.core.query.product.TypeQuery;
import org.duohuo.core.service.product.BrandService;
import org.duohuo.core.service.product.FeatureService;
import org.duohuo.core.service.product.ProductService;
import org.duohuo.core.service.product.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前台商品
 * 
 * @author Kw
 *
 *Date: 2015年10月28日
 */
@Controller
public class FrontProductController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private FeatureService featureService;

	// 商品列表页面
	@RequestMapping(value = "/product/display/list.shtml")
	public String list(Integer pageNo, Integer brandId, String brandName, Integer typeId, String typeName,
			ModelMap model) {

		// 加载商品属性
		FeatureQuery featureQuery = new FeatureQuery();

		List<Feature> features = featureService.getFeatureList(featureQuery);
		// 显示在页面
		model.addAttribute("features", features);

		// 分页参数
		StringBuilder params = new StringBuilder();
		// 设置页号
		ProductQuery productQuery = new ProductQuery();
		productQuery.setPageNo(Pagination.cpn(pageNo));
		// 设置每页数
		productQuery.setPageSize(Product.FRONT_PAGE_SIZE);
		// 设置Id逆序
		productQuery.orderbyId(false);
		// 条件 TODO
		// 隐藏已选条件
		boolean flag = false;
		// 条件Map
		Map<String, String> query = new LinkedHashMap<String, String>();

		// 品牌ID
		if (null != brandId) {
			productQuery.setBrandId(brandId);
			flag = true;
			// 显示在页面
			model.addAttribute("brandId", brandId);
			model.addAttribute("brandName", brandName);

			query.put("品牌", brandName);

			params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
		} else {
			// 加载商品品牌
			// 品牌条件对象
			BrandQuery brandQuery = new BrandQuery();
			// 设置指定字段
			brandQuery.setFields("id,name");
			// 设置可见
			brandQuery.setIsDisplay(1);
			// 加载品牌
			List<Brand> brands = brandService.getBrandList(brandQuery);
			// 显示在页面
			model.addAttribute("brands", brands);
		}
		// 类型ID
		if (null != typeId) {
			productQuery.setTypeId(typeId);
			flag = true;
			query.put("类型", typeName);
			// 显示在页面
			model.addAttribute("typeId", typeId);
			model.addAttribute("typeName", typeName);
			params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);
		} else {
			// 加载商品类型
			TypeQuery typeQuery = new TypeQuery();
			// 指定查询哪些字段
			typeQuery.setFields("id,name");
			typeQuery.setIsDisplay(1);
			typeQuery.setParentId(0);
			List<Type> types = typeService.getTypeList(typeQuery);
			// 显示在页面
			model.addAttribute("types", types);
		}
		model.addAttribute("flag", flag);
		// 条件
		model.addAttribute("query", query);

		// 加载带有分页的商品
		Pagination pagination = productService.getProductListWithPage(productQuery);

		// 分页页面展示 //String params = "brandId=1&name=2014瑜伽服套装新款&pageNo=1";
		String url = "/product/display/list.shtml";
		pagination.pageView(url, params.toString());

		model.addAttribute("pagination", pagination);

		return "product/product";
	}

}
