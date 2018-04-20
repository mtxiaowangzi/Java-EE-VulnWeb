package com.eveino.web.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WordsFilter implements Filter {

	private List<String> bandWords = new ArrayList<>();
	private List<String> auditWords = new ArrayList<>();
	private List<String> remainWords = new ArrayList<>();

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			value = URLDecoder.decode(value,"utf-8");
			for (String regex : bandWords) {
				Pattern pattern = Pattern.compile(regex);
				Matcher m = pattern.matcher(value);
				if (m.matches()) {
					request.setAttribute("message", value + " is bandWords");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;
				}
			}
			for (String regex : auditWords) {
				Pattern pattern = Pattern.compile(regex);
				Matcher m = pattern.matcher(value);
				if (m.matches()) {
					request.setAttribute("message", value + " is auditWords");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;
				}
			}
			for (String regex : remainWords) {
				Pattern pattern = Pattern.compile(regex);
				Matcher m = pattern.matcher(value);
				if (m.matches()) {
					request.setAttribute("message", value + " is remainWords");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String path = WordsFilter.class.getClassLoader().getResource("com/eveino/words").getPath();
		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (!file.getName().endsWith(".txt")) {
				continue;
			}
			try {
				String line = null;
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((line = br.readLine()) != null) {
					String[] s = line.split("\\|");
					if (s.length != 2) {
						continue;
					}

					if (s[1].trim().equals("1")) {
						bandWords.add(s[0]);
					}
					if (s[1].trim().equals("2")) {
						remainWords.add(s[0]);
					}
					if (s[1].trim().equals("3")) {
						auditWords.add(s[0]);
					}
				}
				br.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
