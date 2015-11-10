package org.duohuo.core.service.user;

import java.util.List;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.user.Buyer;
import org.duohuo.core.query.user.BuyerQuery;

/**
 * 
 * @author Kw
 *
 * Date: 2015年11月10日
 */
public interface BuyerService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addBuyer(Buyer buyer);

	/**
	 * 根据主键查询
	 */
	public Buyer getBuyerByKey(String id);

	/**
	 * 根据主键批量查询
	 */
	public List<Buyer> getBuyersByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateBuyerByKey(Buyer buyer);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param buyerQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param buyerQuery
	 *            查询条件
	 * @return
	 */
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery);
}
