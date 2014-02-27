package com.shopping.zhouyang.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shopping.guoguo.dao.impl.GoodsDao4MySqlImpl;
import com.shopping.guoguo.pojo.Goods;

public class GoodsDao4MySqlImplTest {

	@Test
	public void testGetGoodById() {
		Goods good = new GoodsDao4MySqlImpl().getGoodByGid(2);
		System.out.println(good.getName());
	}

}
