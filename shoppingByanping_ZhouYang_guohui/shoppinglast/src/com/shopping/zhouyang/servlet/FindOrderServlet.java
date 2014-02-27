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

public class FindOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				String oid = request.getParameter("oid").trim();
				
				Order order = OrderServiceImpl.getInstance().showOrderByOid(oid);
				List<OrderVo> orderVos = new ArrayList<OrderVo>();
				OrderVo orderVo = new OrderVo();
				orderVo.setOrder(order);
				orderVos.add(orderVo);
				
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
