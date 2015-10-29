package org.duohuo.core.dao.product;

import java.util.List;

import org.duohuo.core.bean.product.Brand;

/**
 * 品牌
 * @author Kw
 *
 * Date: 2015年10月29日
 */
public interface BrandDao {
	//List集合
	public List<Brand> getBrandListWithPage(Brand brand);
	
	//查询总记录数
	public int getBrandCount(Brand brand);
	//添加品牌
	public void addBrand(Brand brand);
}