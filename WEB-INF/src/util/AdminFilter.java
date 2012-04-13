package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import util.session.Message;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class AdminFilter implements Filter {

    public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if(session.getAttribute("admin") != null) {
			chain.doFilter(request, response);
		}
		else {
			Message.addError((HttpServletRequest) request, "Accès interdit");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
