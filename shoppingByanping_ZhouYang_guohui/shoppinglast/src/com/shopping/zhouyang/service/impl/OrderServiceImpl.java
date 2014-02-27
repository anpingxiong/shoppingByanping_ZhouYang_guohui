package com.shopping.zhouyang.service.impl;

import java.util.List;

import com.shopping.factory.CreateDaoFactory;

import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.zhouyang.dao.OrderDao;
import com.shopping.zhouyang.service.OrderService;

public class OrderServiceImpl implements OrderService {
			private static OrderService orderService  = new OrderServiceImpl();
			private static OrderDao orderDao = (OrderDao)CreateDaoFactory.createDao("com.shopping.zhouyang.dao.impl.OrderDao");

	private OrderServiceImpl(){}
	public static OrderService getInstance(){
		return orderService;
	}
	
	public int addOrder(Order order) {
		return orderDao.saveOrder(order);

	}
	public Order showOrderByOid(String oid) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByOid(oid);
	}
	public List<Order> showOrdersByUid(int uid) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersByUid(uid);
	}
	public int cancelOrderByOid(String oid) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrderByOid(oid);
	}
	public int updateOrderByOid(String oid, Double total) {
		// TODO Auto-generated method stub
		return orderDao.alterOrderByOid(oid, total);
	}
	public List<Order> showAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}
	public int updateOrderStateByOid(String oid, int state) {
		// TODO Auto-generated method stub
		return orderDao.alterOrderStateByOid(oid, state);
	}
	public List<Order> showOrdersByState(int state) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersByState(state);
	}
	public List<Order> showAllOrdersByPage(PageVo pageVo) {
		// TODO Auto-generated method stub
		return orderDao.getAllOrdersByPage(pageVo.getFirstIndex(),pageVo.getMaxResult());
	}
	public int showAllOrderCount() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrderCount();
	}

}
