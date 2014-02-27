package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class ShowNewGoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("newGoods.do");
		List<Goods> newGoods = GoodsServiceImpl.getInstance().receiveNewGoods();
		request.setAttribute("newGoods", newGoods);
		request.getRequestDispatcher("./index.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request,response);

	}

}
