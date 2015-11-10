package org.duohuo.core.service.user;

import java.util.List;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.user.Addr;
import org.duohuo.core.query.user.AddrQuery;

/**
 * 
 * @author Kw
 *
 * Date: 2015年11月10日
 */
public interface AddrService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr);

	/**
	 * 根据主键查询
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

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
	public Integer updateAddrByKey(Addr addr);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param addrQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param addrQuery
	 *            查询条件
	 * @return
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
}
