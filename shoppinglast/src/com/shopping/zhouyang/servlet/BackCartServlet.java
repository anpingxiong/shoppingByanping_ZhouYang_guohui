package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class BackCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name =	request.getParameter("name");

			Goods good = new Goods();
			good = GoodsServiceImpl.getInstance().receiveGoodByName(name);
			int gid = good.getGid();
			Cookie[] cookies = request.getCookies();
			for(int i =0;i<cookies.length;i++){
				if(cookies[i].getName().equals(gid+"")){
					Cookie cookie = new Cookie(gid+"",null); 
					cookie.setMaxAge(0); 
					//cookie.setPath("/");//根据你创建cookie的路径进行填写 
					response.addCookie(cookie); 
				}
			}
			//response.sendRedirect("./cart_add.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
