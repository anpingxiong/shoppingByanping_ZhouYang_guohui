package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.BuyGoodVo;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class CartShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BuyGoodVo> goods = new ArrayList<BuyGoodVo>();
		request.getParameter("num");
		
		Cookie[] cookies = request.getCookies();
	 if(cookies.length == 1){response.sendRedirect("./cart_see.jsp");}else{
		for (int i = 0; i < cookies.length; i++) {
			
			if (cookies[i].getName().equals("JSESSIONID")) {
				
				continue;
			}
			BuyGoodVo good = new BuyGoodVo();
			good.setGood(GoodsServiceImpl.getInstance().receiveGoodByGid(Integer.parseInt(cookies[i].getName())))  ;
		good.setCount(Integer.parseInt(cookies[i].getValue()));
	      	goods.add(good);
	 
		}


		request.setAttribute("goods", goods);
		request.getRequestDispatcher("./cart_add.jsp").forward(request, response);
	 }
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
