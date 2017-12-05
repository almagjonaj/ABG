package com.abg.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abg.admin.model.Admin;

/*
@WebFilter(filterName = "AuthFilter", urlPatterns = { "/adminPages/*" })
*/
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();

			if (reqURI.indexOf("/adminPages/adminLogIn.xhtml") >= 0) {
				System.out.println("kerkohet login");
				chain.doFilter(request, response);
			}

			else if ((ses != null) && (ses.getAttribute("admin") != null)) {

				System.out.println("Sesioni nuk eshte null.");

				Admin admin = (Admin) ses.getAttribute("admin");

				System.out.println("Admini eshte: " + admin.getAdmin_name());

				chain.doFilter(request, response);

			}

			else {

				System.out.println("Sesioni ose admin eshte null");
				resp.sendRedirect(reqt.getContextPath() + "/adminPages/adminLogIn.xhtml");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}