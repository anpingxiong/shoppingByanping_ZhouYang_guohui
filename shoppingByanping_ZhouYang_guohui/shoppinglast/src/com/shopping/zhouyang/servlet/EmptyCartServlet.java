package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			response.sendRedirect("./cart_see.jsp");		
		} else {
			try 
			{ 
			for(int i=0;i<cookies.length;i++) 
			{ 
			Cookie cookie = new Cookie(cookies[i].getName(),null); 
			cookie.setMaxAge(0); 
			//cookie.setPath("/");//根据你创建cookie的路径进行填写 
			response.addCookie(cookie); 
			} 
			}catch(Exception ex) 
			{ 
			System.out.println("清空Cookies发生异常！"); 
			} 
			response.sendRedirect("./cart_see.jsp");
		}


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
