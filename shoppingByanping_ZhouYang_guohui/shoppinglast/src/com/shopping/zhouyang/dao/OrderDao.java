package com.shopping.zhouyang.dao;

import java.util.List;

import com.shopping.guoguo.pojo.Order;

 

 

public interface OrderDao {
	//添加一个新订单
				public int saveOrder(Order order);
	//通过订单id得到该订单
				public Order getOrderByOid(String oid);
	//通过用户id查找该用户的所有订单
				public List<Order> getOrdersByUid(int uid);
	//通过订单id取消该订单
				public int deleteOrderByOid(String oid);
	//通过订单id修改订单的总价格
				public int alterOrderByOid(String oid,Double total);
	//拿到说有的订单，在后台管理拿到
				public List<Order> getAllOrders();
	//通过订单id,修改订单状态
				public int alterOrderStateByOid(String oid,int state);
	//根据订单state获得相对的订单
				public List<Order> getOrdersByState(int state);
				
				
	
	//订单分页
				public List<Order> getAllOrdersByPage(int firstIndex,int maxResult);
	//获得所有订单数量
				public int getAllOrderCount();

				
}
