package com.eveino.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.eveino.entity.User;
import com.eveino.exception.UserExistEception;
import com.eveino.service.BusinessServer;
import com.eveino.service.impl.BusinessServerImpl;
import com.eveino.utils.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServer bs = new BusinessServerImpl();
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setId(WebUtils.generateID());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			bs.registerUser(user);
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (SQLException | UserExistEception e) {
			request.setAttribute("message", "用户已存在");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

}