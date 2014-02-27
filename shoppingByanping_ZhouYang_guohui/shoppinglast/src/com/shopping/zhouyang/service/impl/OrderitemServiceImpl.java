package com.shopping.zhouyang.service.impl;

import java.util.List;

import com.shopping.factory.CreateDaoFactory;

import com.shopping.guoguo.pojo.Orderitem;
import com.shopping.zhouyang.dao.OrderitemDao;
import com.shopping.zhouyang.service.OrderitemService;

public class OrderitemServiceImpl implements OrderitemService {
private static OrderitemService orderitemService = new OrderitemServiceImpl();
private static OrderitemDao orderitemDao = (OrderitemDao)CreateDaoFactory.createDao("com.shopping.zhouyang.dao.impl.OrderitemDao");

private OrderitemServiceImpl(){}
	
	public static OrderitemService getInstance(){
		return orderitemService;
	} 
	
	public List<Orderitem> showOrderitemByOid(String oid) {
		// TODO Auto-generated method stub
		return orderitemDao.getOrderitemByOid(oid);
	}

	public int addOrderitem(Orderitem orderitem) {
		return orderitemDao.saveOrderitem(orderitem);

	}

	public int deleteOrderitemByOid(String oid) {

		return orderitemDao.removeOrderitemByOid(oid);
	}

}
