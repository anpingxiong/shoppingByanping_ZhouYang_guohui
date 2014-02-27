package com.shopping.anping.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.lucene.dao.impl.GetPPGoodsName;
import com.shopping.lucene.dao.impl.IndexDaoImpl;

public class LucenceTest {

	@Test
	public void test() {
	   System.out.println(GetPPGoodsName.getName(1));
	}
	@Test
	public void SearchTest(){
	Goods  good = 	(Goods) new IndexDaoImpl().search("新商品 联想", 0,10).list.get(0);
	System.out.println(good.getName());
	}
	@Test
  public  void  deleteTest(){
	  new IndexDaoImpl().delete(1);
  }
	@Test
	public void getPPNameTest(){
	System.out.println(	new GetPPGoodsName().getName(7));
	}
}
