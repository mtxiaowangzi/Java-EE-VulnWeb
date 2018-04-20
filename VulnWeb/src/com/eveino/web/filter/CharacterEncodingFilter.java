package com.eveino.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eveino.web.wrapper.EncodingRequest;

public class CharacterEncodingFilter implements Filter {
	private FilterConfig config;
	private String pageEncoding;
	private String defaultEncoding = "UTF-8";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		pageEncoding = config.getInitParameter("charset");
		if (pageEncoding == null) {
			pageEncoding = defaultEncoding;
		}
		request.setCharacterEncoding(pageEncoding);
		response.setCharacterEncoding(pageEncoding);
		response.setContentType("text/html;charset=" + pageEncoding);

		
		chain.doFilter(new EncodingRequest(request), response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
