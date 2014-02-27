package com.shopping.zhouyang.service;

import java.util.List;

import com.shopping.guoguo.pojo.Orderitem;

public interface OrderitemService {
		public List<Orderitem> showOrderitemByOid(String oid);
		public int addOrderitem(Orderitem orderitem);
		public int deleteOrderitemByOid(String oid);
}
