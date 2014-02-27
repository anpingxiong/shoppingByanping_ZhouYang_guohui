package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.NoticeServiceImpl;
import com.shopping.guoguo.pojo.Notice;

public class ShowOnePlacardServlet extends HttpServlet {

	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 	response.setContentType("text/html");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		 response.setDateHeader("Expires",0);
		 response.setHeader("Pragma", "no-cache");
		 int  id = Integer.parseInt(request.getParameter("id"));
	  Notice notice =   NoticeServiceImpl.getInstance().getNoticeById(id);
		StringBuffer  sb  = new  StringBuffer();
		sb.append("[").append("{title:\"").append(notice.getTitle()+"\"").append(",").append("content:\"").append(notice.getContent()+"\"").append(",").append("pdate:\"").append(notice.getPdate()+"\"")
		.append(",").append("overDate:\"").append(notice.getOverdate()+"\"").append("}").append("]");
		System.out.println(sb);
		PrintWriter out = response.getWriter();
	   out.print(sb);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
