package com.abg.security;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
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

@WebFilter(filterName = "UserFilter", urlPatterns = { "/userPages/*" })
public class UserFilter implements Filter {

	public UserFilter() {
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

			if (reqURI.indexOf("/userPages/llogaria.xhtml") >= 0 && ses.getAttribute("user") == null) {
				resp.sendRedirect(reqt.getContextPath() + "/userPages/index.xhtml");
			}

			else if ((ses != null) && (ses.getAttribute("admin") != null)) {
				resp.sendRedirect(reqt.getContextPath() + "/adminPages/adminPage.xhtml");
			}

			else if (reqURI.indexOf("/userPages/index.xhtml") >= 0
					|| reqURI.indexOf("/userPages/destinations.xhtml") >= 0
					|| reqURI.indexOf("/userPages/contact.xhtml") >= 0
					|| reqURI.indexOf("/userPages/search.xhtml") >= 0) {
				chain.doFilter(request, response);
			}

			else if ((ses != null) && (ses.getAttribute("user") != null)) {

				if (!reqt.getRequestURI().startsWith(reqt.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip
																														// JSF
					// resources
					// (CSS/JS/Images/etc)
					resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
					resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
					resp.setDateHeader("Expires", 0); // Proxies.
				}

				chain.doFilter(request, response);

			}

			else {
				resp.sendRedirect(reqt.getContextPath() + "/userPages/index.xhtml");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}
