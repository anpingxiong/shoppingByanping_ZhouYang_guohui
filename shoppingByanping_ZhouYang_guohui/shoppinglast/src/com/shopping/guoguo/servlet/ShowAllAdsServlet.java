package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Ad;
import com.shopping.guoguo.service.impl.AdServiceImpl;

public class ShowAllAdsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Ad> ads = AdServiceImpl.getInstance().getAllAds();
	    String  url  =  request.getParameter("url");
		request.setAttribute("ads", ads);
		request.getRequestDispatcher("./manage/"+url).forward(request, response);
		

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
