package org.duohuo.core.service.product;

import javax.annotation.Resource;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Brand;
import org.duohuo.core.dao.product.BrandDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 品牌事务
 * @author Kw
 *
 * Date: 2015年10月29日
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Resource
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand){
		//1:起始页  startRow = (pageNo - 1)*pageSize
		//2:每页数
		//3:总记录数
		Pagination  pagination = new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//Brand集合
		pagination.setList(brandDao.getBrandListWithPage(brand));
		
		return pagination;
	}

	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}
}
