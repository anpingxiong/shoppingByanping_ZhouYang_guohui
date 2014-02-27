package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.OrderVo;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.zhouyang.service.impl.OrderServiceImpl;

public class ShowOrderManageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		//后台分页
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	 	int maxResult = 5;
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(currentPage);
		pageVo.setMaxResult(maxResult);
		pageVo.setTotalResult(OrderServiceImpl.getInstance().showAllOrderCount());
		
		List<Order> orders = new ArrayList<Order>();
		orders = OrderServiceImpl.getInstance().showAllOrdersByPage(pageVo);
      List<OrderVo> orderVos = new ArrayList<OrderVo>();
		for(Order order : orders){
			OrderVo orderVo = new OrderVo();
			orderVo.setOrder(order);
		 	orderVos.add(orderVo);
		}
 
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("orderVos", orderVos);
		request.setAttribute("isPageIn", "11111111");
		request.getRequestDispatcher("./manage/OrderManage.jsp").forward(request,
			response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
