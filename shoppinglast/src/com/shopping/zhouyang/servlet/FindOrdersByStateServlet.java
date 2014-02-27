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
import com.shopping.zhouyang.service.impl.OrderServiceImpl;

public class FindOrdersByStateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				int state = Integer.parseInt(request.getParameter("state"));

				List<Order> orders = new ArrayList<Order>();
				List<OrderVo> orderVos = new ArrayList<OrderVo>();
				orders = OrderServiceImpl.getInstance().showOrdersByState(state);
	
				for(Order order:orders){
					OrderVo orderVo = new OrderVo();
					orderVo.setOrder(order);
					orderVos.add(orderVo);
				}

				request.setAttribute("orderVos", orderVos);
			    request.setAttribute("isPageIn", "11111");			//判断是从主页进入order.jsp还是从订单提交进入
			   request.getRequestDispatcher("./manage/OrderManage.jsp").forward(request, response);
				}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
