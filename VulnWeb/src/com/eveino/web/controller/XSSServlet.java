package com.eveino.web.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDemo1
 */
public class XSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Object, Object> hMap = new LinkedHashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XSSServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> pE = request.getParameterNames();
		while (pE.hasMoreElements()) {
			String name = pE.nextElement();
			String value = request.getParameter(name);
			hMap.put(name, value);
		}
		request.setAttribute("hMap", hMap);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
