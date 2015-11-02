package org.duohuo;

import java.util.List;

import org.duohuo.common.junit.SpringJunitTest;
import org.duohuo.core.bean.product.Brand;
import org.duohuo.core.query.product.BrandQuery;
import org.duohuo.core.service.product.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Kw
 *
 * Date: 2015年11月1日
 */
public class TestBrand extends SpringJunitTest{

	@Autowired
	private BrandService brandService;
	@Test
	public void testGet() throws Exception {
		BrandQuery  brandQuery = new BrandQuery();
		
//		brandQuery.setFields("id");
//		brandQuery.setNameLike(true);
//		brandQuery.setName("腾");
		brandQuery.orderbyId(false);
		
		brandQuery.setPageNo(1);
		brandQuery.setPageSize(2);
		
		List<Brand> brands = brandService.getBrandList(brandQuery);
		
		for (Brand b : brands) {
			System.out.println(b);
		}
	}
}
