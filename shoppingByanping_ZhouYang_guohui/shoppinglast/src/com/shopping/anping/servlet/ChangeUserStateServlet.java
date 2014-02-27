package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.UserServiceImpl;

public class ChangeUserStateServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		int  id  =Integer.parseInt(request.getParameter("uid"));
     int state  = Integer.parseInt(request.getParameter("state"));
     PrintWriter  out = response.getWriter();
     int result = UserServiceImpl.getInstance().modifyUserState(id, state);
		 if(result!=-1){
			 if(state==1){
			 out.print("已激活!");
			 }else{
				 out.print("已冻结!");
			 }
		 }else{
			 out.print("更改失败!");
		 }
		 out.flush();
		 out.close();
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 this.doGet(request, response);
	}

}
