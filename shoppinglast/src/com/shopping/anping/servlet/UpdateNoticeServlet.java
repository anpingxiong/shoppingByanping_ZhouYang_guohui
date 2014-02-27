package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.NoticeServiceImpl;
import com.shopping.guoguo.pojo.Notice;
import com.shopping.util.StringToDate;

public class UpdateNoticeServlet extends HttpServlet {
  
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       int id  =  Integer.parseInt(request.getParameter("id"));
           String title   =   request.getParameter("title");
           String content  =  request.getParameter("content");
           Date pdate   =NoticeServiceImpl.getInstance().getNoticeById(id).getPdate();
        		   
        
           String overDate   = request.getParameter("overDate");
           Notice  notice   = new Notice();
           notice.setId(id);
           notice.setTitle(title);
           notice.setContent(content);
           try {
			notice.setPdate(pdate);
			notice.setOverdate(StringToDate.parseStringToDate(overDate));
		//在此update
			NoticeServiceImpl.getInstance().updateNotice(notice);
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
