package com.shopping.guoguo.pojo;

public class Orderitem {
private int id;
private Order order;
private Goods goods;
private  int num;
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}


}
