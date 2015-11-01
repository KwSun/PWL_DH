package org.duohuo.core.service.product;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Brand;
//import org.duohuo.core.query.product.BrandQuery;

/**
 * 业务层
 * 品牌
 * @author Kw
 *
 * Date: 2015年10月29日
 */
public interface BrandService {
	//获取分页列表对象
	public Pagination getBrandListWithPage(Brand brand);
	
	
	//添加品牌
	public void addBrand(Brand brand);
	
	//删除
	public void deleteBrandByKey(Integer id);
	//删除 批量
	public void deleteBrandByKeys(Integer[] ids);//List<Integer>  ids
	//修改
	public void updateBrandByKey(Brand brand);
	
	//查询
	public Brand getBrandByKey(Integer id);
}
