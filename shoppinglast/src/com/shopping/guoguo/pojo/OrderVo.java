package com.shopping.guoguo.pojo;

import java.util.ArrayList;
import java.util.List;

import com.shopping.zhouyang.dao.impl.AddressDao4MySqlImpl;
import com.shopping.zhouyang.dao.impl.OrderDao4MySqlImpl;
import com.shopping.zhouyang.dao.impl.OrderitemDao4MySqlImpl;

public class OrderVo {

	 
		private Order order;
		private Address address;
		private List<Orderitem> orderitems = new ArrayList<Orderitem>();
		public Order getOrder() {
			
			return order;
		}
		public void setOrder(Order order) {
		 	//在setOrder的同时，用servic将Address和orderitems全部拿到
			this.address = new AddressDao4MySqlImpl().getAddressByOid(order.getOid());
			this.orderitems =new OrderitemDao4MySqlImpl().getOrderitemByOid(order.getOid());
		 	this.order = order;
		}
		public Address getAddress() {
			return address;
		}
		public List<Orderitem> getOrderitems() {
			return orderitems;
		}
	
}


