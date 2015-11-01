package org.duohuo;

import org.duohuo.common.junit.SpringJunitTest;
import org.duohuo.core.bean.TestTb;
import org.duohuo.core.service.TestTbService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author Kw
 *
 * Date: 2015年10月28日
 */

public class TestTestTb extends SpringJunitTest{

	@Autowired
	private TestTbService testTbService;
	@Test
	public void testAdd() throws Exception {
		TestTb testTb = new TestTb();
		testTb.setName("小王子");
		
		testTbService.addTestTb(testTb);
	}
}