package com.eveino.web.wrapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request;

	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (!request.getMethod().equalsIgnoreCase("get")) {
			return value;
		}
		if (value == null) {
			return null;
		}
		try {
			return new String(value.getBytes("iso8859-1"), request.getCharacterEncoding());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
