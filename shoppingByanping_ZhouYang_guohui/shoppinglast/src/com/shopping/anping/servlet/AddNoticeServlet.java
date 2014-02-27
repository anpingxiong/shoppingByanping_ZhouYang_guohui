package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
 
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.NoticeServiceImpl;
import com.shopping.guoguo.pojo.Notice;
import com.shopping.util.StringToDate;

public class AddNoticeServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 
         String title   =   request.getParameter("title");
         String content  =  request.getParameter("content");
    
         String overDate   = request.getParameter("overDate");
         Notice  notice   = new Notice();
     
         notice.setTitle(title);
         notice.setContent(content);
         try {
			notice.setPdate(new Date());
			notice.setOverdate(StringToDate.parseStringToDate(overDate));
		//在此update
			NoticeServiceImpl.getInstance().addNotice(notice);
			response.sendRedirect("./manage/PlacardManage.jsp");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
