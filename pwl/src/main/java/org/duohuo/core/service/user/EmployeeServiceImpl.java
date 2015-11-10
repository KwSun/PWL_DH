package org.duohuo.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.duohuo.common.page.Pagination;
import org.duohuo.core.bean.user.Employee;
import org.duohuo.core.dao.user.EmployeeDao;
import org.duohuo.core.query.user.EmployeeQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Kw
 *
 * Date: 2015年11月10日
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	EmployeeDao employeeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Employee getEmployeeByKey(String id) {
		return employeeDao.getEmployeeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByKeys(List<String> idList) {
		return employeeDao.getEmployeesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return employeeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return employeeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateEmployeeByKey(Employee employee) {
		return employeeDao.updateEmployeeByKey(employee);
	}
	
	@Transactional(readOnly = true)
	public Pagination getEmployeeListWithPage(EmployeeQuery employeeQuery) {
		Pagination p = new Pagination(employeeQuery.getPageNo(),employeeQuery.getPageSize(),employeeDao.getEmployeeListCount(employeeQuery));
		p.setList(employeeDao.getEmployeeListWithPage(employeeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery) {
		return employeeDao.getEmployeeList(employeeQuery);
	}
}
