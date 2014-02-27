package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.FavoriteServiceImpl;
import com.shopping.guoguo.pojo.User;

public class DeleteFavoriteServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          int id  =  Integer.parseInt(request.getParameter("id"));
          User  user  =(User)request.getSession().getAttribute("user");
          FavoriteServiceImpl.getInstatnce().deleteFavoriteById(id);
          request.getRequestDispatcher("./favorite.jsp").forward(request, response);
         
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	}

}
