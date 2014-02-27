package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
	    String username   =	   request.getParameter("username");
	   request.getSession().setAttribute("adminName", username);
	    System.out.println(request.getSession().getAttribute("adminName"));
	    PrintWriter out = response.getWriter();
         out.flush();
	    out.close();
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 this.doGet(request, response);
	}

}
