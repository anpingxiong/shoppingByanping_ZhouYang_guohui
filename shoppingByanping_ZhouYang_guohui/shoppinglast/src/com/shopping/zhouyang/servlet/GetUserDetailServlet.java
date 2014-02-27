package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.guoguo.pojo.User;

public class GetUserDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		String getName = user.getUsername();
//		String getAddress = user.getAddress();
//		String post = user.getPost();
//		String tel = user.getTel();
//		
//		request.setAttribute("getName", getName);
//		request.setAttribute("getAddress", getAddress);
//		request.setAttribute("post", post);
//		request.setAttribute("tel", tel);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("./cart_checkout.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
