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

public class SearchGoodsByOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bsort = request.getParameter("bigSort");
 
		String content = request.getParameter("content");
		List<Goods> goods = null;
		if (bsort.equals(null)) {
			int bsortId = Integer.parseInt(bsort);
			goods = GoodsServiceImpl.getInstance().getGoodsOrder(bsortId,
					content);
		} else {
			goods = GoodsServiceImpl.getInstance().receiveAllGoods();
		}
		request.setAttribute("pgoods", goods);
		request.getRequestDispatcher("./manage/GoodsManage.jsp").forward(
				request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
