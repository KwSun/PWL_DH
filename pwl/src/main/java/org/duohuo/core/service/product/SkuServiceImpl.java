package org.duohuo.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Sku;
import org.duohuo.core.dao.product.SkuDao;
import org.duohuo.core.query.product.SkuQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 
 * @author Kw
 *
 * Date: 2015年11月2日
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

	@Resource
	SkuDao skuDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSku(Sku sku) {
		return skuDao.addSku(sku);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Sku getSkuByKey(Integer id) {
		return skuDao.getSkuByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkusByKeys(List<Integer> idList) {
		return skuDao.getSkusByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return skuDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return skuDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSkuByKey(Sku sku) {
		return skuDao.updateSkuByKey(sku);
	}
	
	@Transactional(readOnly = true)
	public Pagination getSkuListWithPage(SkuQuery skuQuery) {
		Pagination p = new Pagination(skuQuery.getPageNo(),skuQuery.getPageSize(),skuDao.getSkuListCount(skuQuery));
		p.setList(skuDao.getSkuListWithPage(skuQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkuList(SkuQuery skuQuery) {
		return skuDao.getSkuList(skuQuery);
	}
}
