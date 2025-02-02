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


@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {

	
	public AuthFilter() {
		super();
		
	}

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {

	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpSession session = req.getSession();

	    String uri = req.getRequestURI();
	   

	    if(!uri.endsWith("/login") &&
	            !uri.endsWith("/logout") &&
	            !uri.endsWith("/growth") &&
	            !uri.endsWith("/growthList") &&
	            !uri.endsWith("/indoorPlants") &&
	            !uri.endsWith("/registered") &&
	            !uri.endsWith("/plantsList") &&
	            !uri.endsWith("/plantsDetail") &&
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

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
