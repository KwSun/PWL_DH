package org.duohuo.core.dao.product;

import java.util.List;

import org.duohuo.core.bean.product.Brand;
import org.duohuo.core.query.BrandQuery;
/**
 * 品牌
 * @author Kw
 *
 * Date: 2015年10月29日
 */
public interface BrandDao {
	
	//List集合（分页）
	public List<Brand> getBrandListWithPage(Brand brand);
	
	//查询集合
	public List<Brand> getBrandList(BrandQuery brandQuery);
	
	//查询总记录数
	public int getBrandCount(Brand brand);
	//添加品牌
	public void addBrand(Brand brand);
	
	//删除
	public void deleteBrandByKey(Integer id);
	//删除 批量
	public void deleteBrandByKeys(Integer[] ids);//List<Integer> ids,后面BrandDao.xml的collection就是list
	//修改
	public void updateBrandByKey(Brand brand);
	
	//查询
	public Brand getBrandByKey(Integer id);
}
