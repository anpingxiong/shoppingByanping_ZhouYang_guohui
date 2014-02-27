package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.User;

public class RegisterServlet extends HttpServlet {
 
  public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String username=  request.getParameter("username");
	       String pwd = request.getParameter("pwd");
	       String email =  request.getParameter("email");
	       String truename =request.getParameter("truename");
	       String addr   = request.getParameter("address");
	      String  province=  request.getParameter("province");
	     String  city1= request.getParameter("city1");
	     String  city2= request.getParameter("city2"); 
	    
	      String postcode =  request.getParameter("postcode");
	      String telephone  = request.getParameter("telephone");
	      User user = new User();
	      user.setUsername(username);
	      user.setPassword(pwd);
	      user.setEmail(email);
	      user.setName(truename);
	      user.setAddress(addr);
	      user.setProvince(province);
	      user.setCity(city1);
	      user.setUrban(city2);
	      user.setPost(postcode);
	      user.setTel(telephone);
	      user.setExpense(0.0);
	      user.setLevel(0);
	      user.setState(1);
	      user.setPdate(new Date());
	     UserServiceImpl.getInstance().addUser(user);
	     request.getSession().setAttribute("user", user);
	    response.sendRedirect("./index.jsp");
	}

}
