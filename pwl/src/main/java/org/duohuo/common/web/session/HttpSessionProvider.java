package org.duohuo.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 
 * @author Kw
 *
 * Date: 2015年11月10日
 */
public class HttpSessionProvider implements SessionProvider {

	@Override
	public void setAttribute(HttpServletRequest request, String name, Serializable value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);

	}

	@Override
	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			//销毁，令其失效
			session.invalidate();
		}

	}

	@Override
	public String getSessionId(HttpServletRequest request) {
		request.getSession().getId();
		return null;
	}

}
