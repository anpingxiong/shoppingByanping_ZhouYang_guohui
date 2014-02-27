package com.shopping.zhouyang.service;

import java.util.List;

import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.PageVo;

public interface OrderService {
		public int addOrder(Order order);
		public Order showOrderByOid(String oid);
		public List<Order> showOrdersByUid(int uid);
		public int cancelOrderByOid(String oid);
		public int updateOrderByOid(String oid,Double total);
		public List<Order> showAllOrders();
		public int updateOrderStateByOid(String oid,int state);
		public List<Order> showOrdersByState(int state);
		public List<Order> showAllOrdersByPage(PageVo pageVo);
		public int showAllOrderCount();
}
