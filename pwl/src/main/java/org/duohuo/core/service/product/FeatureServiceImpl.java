package org.duohuo.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Feature;
import org.duohuo.core.dao.product.FeatureDao;
import org.duohuo.core.query.product.FeatureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品属性事务层
 * @author Kw
 *
 * Date: 2015年10月30日
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

	@Resource
	FeatureDao featureDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addFeature(Feature feature) {
		return featureDao.addFeature(feature);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Feature getFeatureByKey(Integer id) {
		return featureDao.getFeatureByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeaturesByKeys(List<Integer> idList) {
		return featureDao.getFeaturesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return featureDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return featureDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateFeatureByKey(Feature feature) {
		return featureDao.updateFeatureByKey(feature);
	}
	
	@Transactional(readOnly = true)
	public Pagination getFeatureListWithPage(FeatureQuery featureQuery) {
		Pagination p = new Pagination(featureQuery.getPageNo(),featureQuery.getPageSize(),featureDao.getFeatureListCount(featureQuery));
		p.setList(featureDao.getFeatureListWithPage(featureQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeatureList(FeatureQuery featureQuery) {
		return featureDao.getFeatureList(featureQuery);
	}
}
