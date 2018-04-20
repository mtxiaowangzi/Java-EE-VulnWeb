package com.eveino.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> types = Arrays.asList(".jpg",".jpeg", ".txt", ".gif", ".zip");
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			if (!ServletFileUpload.isMultipartContent(request)) {
				request.getParameter("username");
				return;
			}
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String inputName = item.getFieldName();
					String inputValue = item.getString("UTF-8");
					System.out.println(inputName + inputValue);
				} else {
					String contentype = item.getContentType();
					//此处校验contentype，上传文件时将头中contentype修改成jpg或jpeg的即可绕过
					if((contentype.toLowerCase().indexOf("jpg")==-1)&&(contentype.toLowerCase().indexOf("jpeg")==-1)) {
						request.setAttribute("message", "上传文件contentype:"+contentype+"，非jpg或jpeg");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
					String filename = item.getName();
					if (filename == null || "".equals(filename.trim())) {
						continue;
					}
					String ext = filename.substring(filename.lastIndexOf("."));
					//此处校验文件后缀，可修改文件后缀为合法的然后上传...不过好像tomcat不解析....
					//并且上传目录一般设置在WEB-INF目录下，该目录不同通过web直接访问
/*					if (!types.contains(ext)) {
						request.setAttribute("message", "错误" + ext + "类型");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
*/
					InputStream in = item.getInputStream();
					int len = 0;
					byte[] buff = new byte[1024];
					String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
					FileOutputStream out = new FileOutputStream(savepath + File.separator + filename);
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
					in.close();
					out.close();
					item.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", "上传成功");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
