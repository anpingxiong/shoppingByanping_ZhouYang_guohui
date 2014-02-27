package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.guoguo.pojo.Address;
import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.OrderVo;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.pojo.User;
import com.shopping.zhouyang.dao.impl.AddressDao4MySqlImpl;
import com.shopping.zhouyang.service.impl.AddressServiceImpl;
import com.shopping.zhouyang.service.impl.OrderServiceImpl;

public class ShowUserOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   	
		List<Order> orders= new ArrayList<Order>();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int uid = user.getUid();
     
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		orders = OrderServiceImpl.getInstance().showOrdersByUid(uid);
		for(Iterator<Order> i = orders.iterator();i.hasNext();){
			 Order order  = i.next();
			OrderVo orderVo = new OrderVo();
			orderVo.setOrder(order);	
		 orderVos.add(orderVo);
	  	}
		

		request.setAttribute("orderVos", orderVos);
	    request.setAttribute("isPageIn", "11111");			//判断是从主页进入order.jsp还是从订单提交进入
	     
		request.getRequestDispatcher("./order.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
