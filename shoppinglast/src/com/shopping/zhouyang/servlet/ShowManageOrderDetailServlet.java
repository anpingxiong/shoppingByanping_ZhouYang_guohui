package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.OrderVo;
import com.shopping.zhouyang.service.impl.OrderServiceImpl;

public class ShowManageOrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		Order order = OrderServiceImpl.getInstance().showOrderByOid(oid);
		OrderVo orderVo = new OrderVo();
		orderVo.setOrder(order);
		request.setAttribute("orderVo", orderVo);
		request.getRequestDispatcher("./manage/order_detail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
