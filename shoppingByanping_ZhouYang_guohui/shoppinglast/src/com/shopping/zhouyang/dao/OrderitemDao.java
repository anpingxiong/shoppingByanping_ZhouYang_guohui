package com.shopping.zhouyang.dao;

import java.util.List;

import com.shopping.guoguo.pojo.Orderitem;

public interface OrderitemDao {
	public List<Orderitem> getOrderitemByOid(String oid);
	public int saveOrderitem(Orderitem orderitem);
	public int removeOrderitemByOid(String oid);
}
