package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public AuthFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {

	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();

	    String uri = req.getRequestURI();
	    if(!uri.endsWith("/login") &&
	            !uri.endsWith("/logout") &&
	            !uri.endsWith("/growth") &&
	            !uri.endsWith("/growthOut") &&
	            !uri.endsWith("/indoorPlants") &&
	            !uri.endsWith("/newRegistretion") &&
	            !uri.endsWith("/plantsList") &&
	            !uri.contains("/css/") &&       
	            !uri.contains("/js/") &&       
	            !uri.contains("/images/")) {    
	        if (session.getAttribute("loginId") == null) {
	            res.sendRedirect(req.getContextPath() + "/login");
	            return;
	        }
	    }
	    chain.doFilter(request, response); // フィルターチェーンを進める
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
