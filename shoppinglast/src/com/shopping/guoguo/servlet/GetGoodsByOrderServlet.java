package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetGoodsByOrderServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//          int  bsortId  = Integer.parseInt(request.getParameter("bigSort_s"));
//          String cotent   = request.getParameter("content_");
	 System.out.println("111111111111111111111111");
	 System.out.println("222222222222222222222222");
	 request.getRequestDispatcher("./index.jsp").forward(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 
	}

}
