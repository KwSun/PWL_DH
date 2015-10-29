package org.duohuo.core.service.product;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Brand;





public interface BrandService  {

	public Pagination getBrandListWithPage(Brand brand);
	
	//添加品牌
	public void addBrand(Brand brand);
}