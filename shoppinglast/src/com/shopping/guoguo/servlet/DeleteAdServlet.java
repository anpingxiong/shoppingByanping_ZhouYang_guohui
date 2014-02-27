package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.service.impl.AdServiceImpl;

public class DeleteAdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		System.out.println("拿到"+aid+"啦");
		AdServiceImpl.getInstance().removeAd(aid);
		response.sendRedirect("./manage/ad.jsp");
		
	}

}
