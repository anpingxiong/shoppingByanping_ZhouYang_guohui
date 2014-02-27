package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.NoticeServiceImpl;
import com.shopping.guoguo.pojo.Notice;

public class ShowPlacardDetailServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      int  id   =Integer.parseInt(request.getParameter("id"));
     
     Notice notice  =    NoticeServiceImpl.getInstance().getNoticeById(id);
 
   request.setAttribute("notice",notice );
   System.out.println(notice.getContent());
   System.out.println(notice.getPdate());
   System.out.println(notice.getTitle());
   request.getRequestDispatcher("./placard_detail.jsp").forward(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
