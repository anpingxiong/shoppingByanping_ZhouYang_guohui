package com.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.shopping.guoguo.pojo.User;

 

public class ManageFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse   resp     = (HttpServletResponse)  response;
        if(req.getSession().getAttribute("user")!=null){
			User user = (User)req.getSession().getAttribute("user");
			if("bod".equals(user.getUsername())){
				if("12345".equals(user.getPassword())){
					chain.doFilter(request, response);
				}else{
		     	req.getSession().invalidate();
		     	resp.sendRedirect("../login.jsp");      }
				}else{
		 	req.getSession().invalidate();
		 	resp.sendRedirect("../login.jsp");	}
	  }else{
			req.getSession().invalidate();
			resp.sendRedirect("../login.jsp");
	  }

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
