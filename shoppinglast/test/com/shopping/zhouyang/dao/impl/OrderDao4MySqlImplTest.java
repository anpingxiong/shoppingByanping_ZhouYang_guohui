package com.shopping.zhouyang.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shopping.anping.dao.impl.UserDao4MySqlImpl;
import com.shopping.guoguo.pojo.Order;

public class OrderDao4MySqlImplTest {

	@Test
	public void testSaveOrder() {
		Order order = new Order();
		order.setOid("20101015");
		order.setTotal(1123.012);
		order.setPayway(1);
		order.setBillinfo(1);
		order.setGetmethod(2);
		order.setTimereq(3);
		order.setExp("希望更快发货，服务质量再提高");
		order.setUser(new UserDao4MySqlImpl().findUserById(1));
		System.out.println(new OrderDao4MySqlImpl().saveOrder(order));
	}
	
	@Test
	public void testGetOrderByUid(){
		System.out.println();
	}
	
	

}
