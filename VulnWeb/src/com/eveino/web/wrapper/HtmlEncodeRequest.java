package com.eveino.web.wrapper;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.eveino.utils.HtmlEncode;

public class HtmlEncodeRequest extends HttpServletRequestWrapper implements ServletRequest {

	private HttpServletRequest request;
	public HtmlEncodeRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (value == null) {
			return value;
		}
		return HtmlEncode.htmlFilter(value);
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = request.getParameterValues(name);
		if (values == null) {
			return null;
		}
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
			values[i] = HtmlEncode.htmlFilter(values[i]);
		}
		return values;
	}
}
