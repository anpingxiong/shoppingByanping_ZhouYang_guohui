package com.shopping.zhouyang.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shopping.guoguo.pojo.Address;

public class AddressDao4MySqlImplTest {

	@Test
	public void testSaveAddress() {
		Address address = new Address();
		address.setGetname("Mary");
		address.setAddress("江西省南昌市双港东路");
		address.setPost("340000");
		address.setTel("3875211");
		address.setOrder(new OrderDao4MySqlImpl().getOrderByOid("20101009"));
		System.out.println(new AddressDao4MySqlImpl().saveAddress(address));
	}

}
