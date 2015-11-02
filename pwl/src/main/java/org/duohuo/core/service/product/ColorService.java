package org.duohuo.core.service.product;

import java.util.List;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.product.Color;
import org.duohuo.core.query.product.ColorQuery;

/**
 * 
 * @author Kw
 *
 * Date: 2015年10月30日
 */
public interface ColorService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addColor(Color color);

	/**
	 * 根据主键查询
	 */
	public Color getColorByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

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
	public Integer updateColorByKey(Color color);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param colorQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getColorListWithPage(ColorQuery colorQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param colorQuery
	 *            查询条件
	 * @return
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
}
