package com.eveino.web.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.eveino.utils.XssDefend;

public class XssDefendRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	public XssDefendRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (value == null) {
			return value;
		}
		return XssDefend.stripXSS(value);
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = request.getParameterValues(name);
		if (values == null) {
			return null;
		}
		for (int i = 0; i < values.length; i++) {
			values[i] = XssDefend.stripXSS(values[i]);
		}
		return values;
	}

}
