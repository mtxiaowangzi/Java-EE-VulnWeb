package com.eveino.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		//过滤恶意字符
		String[] backlist = { "../", "?", "%" };
		String filename = request.getParameter("filename");
		filename = URLDecoder.decode(filename, "UTF-8");
/*		for (int i = 0; i < backlist.length; i++) {
			if (filename.toLowerCase().contains(backlist[i])) {
				System.out.println(filename);
				return;
			}
		}*/
		String path = this.getServletContext().getRealPath("/WEB-INF") + File.separator + filename;
		File file = new File(path);
		try {
			FileInputStream fis = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			response.setHeader("content-disposition", "attachment;filename=" + file.getName());
			int len = 0;
			byte[] buff = new byte[1024];
			while ((len = fis.read(buff)) != -1) {
				os.write(buff, 0, len);
			}
			fis.close();
		} catch (Exception e) {
			request.setAttribute("message", "不对....");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

}
