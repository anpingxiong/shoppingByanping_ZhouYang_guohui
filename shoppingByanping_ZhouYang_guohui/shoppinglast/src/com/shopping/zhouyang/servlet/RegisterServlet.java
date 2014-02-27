package com.shopping.zhouyang.servlet;

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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
			user.setUid(1);
	      user.setUsername("zhouyang");
	      user.setPassword("zhouyang");
	      user.setEmail("340097187@qq.com");
	      user.setName("周洋");
	      user.setAddress("江西吉安");
	      user.setProvince("江西");
	      user.setCity("吉安");
	      user.setUrban("庐陵");
	      user.setPost("343000");
	      user.setTel("18770052459");
	      user.setExpense(0.0);
	      user.setLevel(0);
	      user.setState(1);
//	      user.setPdate(new Date());
	   
	     request.getSession().setAttribute("user", user);
	     response.sendRedirect("./index.jsp");
	     
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
