package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.CommentServiceImpl;
import com.shopping.anping.service.impl.NoticeServiceImpl;
import com.shopping.guoguo.pojo.Comment;
import com.shopping.guoguo.pojo.Notice;
import com.shopping.guoguo.pojo.PageVo;

public class ShowPlacardServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
		response.setContentType("text/html");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		 response.setDateHeader("Expires",0);
		 response.setHeader("Pragma", "no-cache");
		  	int page =  Integer.parseInt(request.getParameter("page"));
			PageVo pageVo = new PageVo();
			pageVo.setCurrentPage(page);
			pageVo.setMaxResult(5);
			///在此我们来跌代我们的placard
			 List<Notice> notices =  NoticeServiceImpl.getInstance().getNoticesByPage(pageVo);
			  
			 StringBuffer  sb  = new StringBuffer("[");
			   for(Notice notice : notices){
				    sb.append("{\"id\":").append(notice.getId()).append(",\"title\":\"").append(notice.getTitle()+"\"").append(",\"content\":\"").append(notice.getContent()+"\"").append(",\"pdate\":\"").append(notice.getPdate()+"\"").append(",\"overdate\":\"").append(notice.getOverdate()+"\"").append(",\"totalPage\":").append(pageVo.getTotalPage()).append("}").append(",");
			   }
			
			   sb.deleteCharAt(sb.length()-1);
			   sb.append("]");
			   System.out.println(sb);
			 PrintWriter out = response.getWriter();
			 if(sb.toString().equals("]")){
					sb=null;
				}
		 
		out.println(sb);
		 out.flush();
		out.close();
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request,response);
	}

}
