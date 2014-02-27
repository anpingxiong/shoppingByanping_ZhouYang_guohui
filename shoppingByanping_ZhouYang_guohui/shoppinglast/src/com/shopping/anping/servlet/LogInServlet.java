package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.exception.PassWordErrorException;
import com.shopping.anping.exception.UserNotExsitsException;
import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.User;

public class LogInServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setDateHeader("Expires",0);
		response.setHeader("Pragma", "no-cache");
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	     
	  User user = new User();
	    user.setUsername(username);
	    user.setPassword(password);
	    String result = null;
	    try {
			User user_1=UserServiceImpl.getInstance().login(user);
			int     state    =   user_1.getState();
			result="登录成功("+state+")!";
			if(state==1){
				  request.getSession().setAttribute("user", user_1);
		 	}
			System.out.println(result);
		} catch (PassWordErrorException e) {
			  result="密码错误!";
		}catch(UserNotExsitsException e){
			result="用户名不存在!";
		}finally{
		  PrintWriter   out = response.getWriter();
	     out.print("<font color='red'>"+result+"</font>");
	    
	     out.flush();
	     out.close();
		}
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
