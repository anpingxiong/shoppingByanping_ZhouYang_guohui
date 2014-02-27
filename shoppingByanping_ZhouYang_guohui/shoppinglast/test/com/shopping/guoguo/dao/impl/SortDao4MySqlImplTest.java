package com.shopping.guoguo.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shopping.guoguo.pojo.Sort;

public class SortDao4MySqlImplTest {

	@Test
	public void testgetSortBySid() {
		int sid = 2;
		Sort sort = new SortDao4MySqlImpl().getSortBySid(sid);
		System.out.println("sid为2的商品类型是："+sort.getName());
	}

}
