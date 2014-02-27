package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.FavoriteServiceImpl;
import com.shopping.guoguo.pojo.Favortie;
import com.shopping.guoguo.pojo.User;

public class ShowAllFavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		      User user  =(User)    request.getSession().getAttribute("user");
		     System.out.println(user.getUid()+"-------------22222222");
              List<Favortie> favorites=   FavoriteServiceImpl.getInstatnce().showAllFavorite(user.getUid());
                request.setAttribute("favorites", favorites);
                request.setAttribute("isFirsteIn", "11");
                request.getRequestDispatcher("./favorite.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

this.doGet(request, response);
	}

}
