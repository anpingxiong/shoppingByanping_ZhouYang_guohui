package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.CommentServiceImpl;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class ShowGoodDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String name = request.getParameter("name");
				Goods good = new Goods();
				good = GoodsServiceImpl.getInstance().receiveGoodByName(name);
				
				request.setAttribute("good", good);
				request.getRequestDispatcher("./goods_detail.jsp").forward(request, response);

				
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
