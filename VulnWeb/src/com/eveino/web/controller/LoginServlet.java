package com.eveino.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eveino.entity.User;
import com.eveino.service.BusinessServer;
import com.eveino.service.impl.BusinessServerImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("")||password.equals("")) {
			request.setAttribute("message", "用户名或密码为空");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession(false);
		User user = new User();
		try {
			user = bs.loginUser(username, password);
		} catch (SQLException e) {
			request.setAttribute("message", "未知错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if (user != null) {
			request.setAttribute("message", "登录成功");
			session.invalidate();
			session = request.getSession();
			request.setAttribute("user", user);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.setAttribute("message", "用户名或密码错误");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
	}

}