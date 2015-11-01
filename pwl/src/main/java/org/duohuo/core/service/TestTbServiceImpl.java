package org.duohuo.core.service;

import javax.annotation.Resource;

import org.duohuo.core.bean.TestTb;
import org.duohuo.core.dao.TestTbDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Kw
 *
 * Date: 2015年10月28日
 */
@Service
@Transactional
public class TestTbServiceImpl implements TestTbService{

	@Resource
	private TestTbDao testTbDao;
	
//	如果查询，关闭事务，只读
//	@Transactional(readOnly = true)
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
		
		//throw new RuntimeException();
	}

}

