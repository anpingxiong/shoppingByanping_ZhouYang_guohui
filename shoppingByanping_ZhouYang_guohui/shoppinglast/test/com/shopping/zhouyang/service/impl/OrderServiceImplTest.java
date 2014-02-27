package com.shopping.zhouyang.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shopping.anping.dao.impl.UserDao4MySqlImpl;
import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.Order;
import com.shopping.zhouyang.dao.impl.OrderDao4MySqlImpl;

public class OrderServiceImplTest {

	@Test
	public void testAddOrder() {
		Order order = new Order();
		order.setOid("21101025");
		order.setTotal(145.69);
		order.setPayway(1);
		order.setBillinfo(1);
		order.setGetmethod(2);
		order.setTimereq(1);
		order.setExp("我很喜欢这一款，希望是真品");
		order.setUser(new UserDao4MySqlImpl().findUserById(1));
		int result = OrderServiceImpl.getInstance().addOrder(order);
		System.out.println(result);
	}

}
