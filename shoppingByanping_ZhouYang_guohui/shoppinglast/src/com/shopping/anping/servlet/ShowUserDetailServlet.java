package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.User;

public class ShowUserDetailServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      int uid  = Integer.parseInt(request.getParameter("uid"));
	   User user =  UserServiceImpl.getInstance().getUserById(uid);
      request.setAttribute("userDetail", user);
      request.getRequestDispatcher("./manage/member_detail.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	
	}

}
