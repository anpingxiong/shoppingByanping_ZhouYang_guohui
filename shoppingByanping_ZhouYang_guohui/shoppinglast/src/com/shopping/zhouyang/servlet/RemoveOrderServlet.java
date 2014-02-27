package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.OrderVo;
import com.shopping.guoguo.pojo.Orderitem;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;
import com.shopping.zhouyang.dao.impl.OrderitemDao4MySqlImpl;
import com.shopping.zhouyang.service.impl.AddressServiceImpl;
import com.shopping.zhouyang.service.impl.OrderServiceImpl;
import com.shopping.zhouyang.service.impl.OrderitemServiceImpl;

public class RemoveOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		Order order  = OrderServiceImpl.getInstance().showOrderByOid(oid);
	    	OrderServiceImpl.getInstance().cancelOrderByOid(oid);
       OrderVo  orderVos    = new OrderVo();
		orderVos.setOrder(order);
		List<Orderitem>   orderitems  = orderVos.getOrderitems();
	    	for(Orderitem  orderitem:orderitems){
        	GoodsServiceImpl.getInstance().alterNumOrdered(orderitem.getGoods().getGid(), orderitem.getNum(), false);
		orderitem.getGoods().getName();
	   	}
 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
