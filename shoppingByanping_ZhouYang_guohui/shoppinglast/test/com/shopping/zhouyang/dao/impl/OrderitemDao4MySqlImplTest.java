package com.shopping.zhouyang.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shopping.guoguo.dao.impl.GoodsDao4MySqlImpl;
import com.shopping.guoguo.pojo.Orderitem;

public class OrderitemDao4MySqlImplTest {

	@Test
	public void testGetOrderitemByOid() {
		List<Orderitem> orderitems = new ArrayList<Orderitem>();
				orderitems = new OrderitemDao4MySqlImpl().getOrderitemByOid("2012101711462652092");
				System.out.println(orderitems.get(0).getNum());
	}

}
