package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.Order;
import com.shopping.zhouyang.service.impl.OrderServiceImpl;

public class DeliverOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String oid = request.getParameter("oid");
		Order   order = 	OrderServiceImpl.getInstance().showOrderByOid(oid);
			double  expense  = order.getTotal();
			int uid  = order.getUser().getUid();
			UserServiceImpl.getInstance().addUserExpense(expense, uid);
			OrderServiceImpl.getInstance().updateOrderStateByOid(oid, 0);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
