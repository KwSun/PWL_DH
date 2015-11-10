package org.duohuo.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.user.Addr;
import org.duohuo.core.dao.user.AddrDao;
import org.duohuo.core.query.user.AddrQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 地址
 * @author Kw
 *
 * Date: 2015年11月10日
 */
@Service
@Transactional
public class AddrServiceImpl implements AddrService {

	@Resource
	AddrDao addrDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr) {
		return addrDao.addAddr(addr);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Addr getAddrByKey(Integer id) {
		return addrDao.getAddrByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrsByKeys(List<Integer> idList) {
		return addrDao.getAddrsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return addrDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return addrDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateAddrByKey(Addr addr) {
		return addrDao.updateAddrByKey(addr);
	}
	
	@Transactional(readOnly = true)
	public Pagination getAddrListWithPage(AddrQuery addrQuery) {
		Pagination p = new Pagination(addrQuery.getPageNo(),addrQuery.getPageSize(),addrDao.getAddrListCount(addrQuery));
		p.setList(addrDao.getAddrListWithPage(addrQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrList(AddrQuery addrQuery) {
		return addrDao.getAddrList(addrQuery);
	}
}
