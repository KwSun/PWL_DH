package org.duohuo.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * Session 供应类
 * @author Kw
 *
 * Date: 2015年11月10日
 */
public interface SessionProvider {

	//向Session设置值,value:用户对象
	public void setAttribute(HttpServletRequest request, String name,Serializable value);
	
	//从Session中取值
	public Serializable getAttribute(HttpServletRequest request,String name);
	
	//退出登陆
	public void logout(HttpServletRequest request);
	
	//获取SessionID
	public String getSessionId(HttpServletRequest request);
}
