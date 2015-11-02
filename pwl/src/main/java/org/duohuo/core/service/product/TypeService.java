package org.duohuo.core.service.product;

import java.util.List;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Type;
import org.duohuo.core.query.product.TypeQuery;



/**
 * 
 * @author Kw
 *
 * Date: 2015年10月30日
 */
public interface TypeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addType(Type type);

	/**
	 * 根据主键查询
	 */
	public Type getTypeByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Type> getTypesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param typeQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getTypeListWithPage(TypeQuery typeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param typeQuery
	 *            查询条件
	 * @return
	 */
	public List<Type> getTypeList(TypeQuery typeQuery);
}
