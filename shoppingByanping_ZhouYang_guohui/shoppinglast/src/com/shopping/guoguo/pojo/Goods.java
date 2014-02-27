package com.shopping.guoguo.pojo;

import java.util.Date;

public class Goods {

private int gid;
private String name;
private double marketprice;
private double nowprice;
private double discount;
private int bargain;
private String exp;
private Sort sort;
private Date pdate;
private int goodsnum;
private int ordernum;
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getMarketprice() {
	return marketprice;
}
public void setMarketprice(double marketprice) {
	this.marketprice = marketprice;
}
public double getNowprice() {
	return nowprice;
}
public void setNowprice(double nowprice) {
	this.nowprice = nowprice;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public int getBargain() {
	return bargain;
}
public void setBargain(int bargain) {
	this.bargain = bargain;
}

public String getExp() {
	return exp;
}
public void setExp(String exp) {
	this.exp = exp;
}
public Sort getSort() {
	return sort;
}
public void setSort(Sort sort) {
	this.sort = sort;
}
public Date getPdate() {
	return pdate;
}
public void setPdate(Date pdate) {
	this.pdate = pdate;
}
public int getGoodsnum() {
	return goodsnum;
}
public void setGoodsnum(int goodsnum) {
	this.goodsnum = goodsnum;
}
public int getOrdernum() {
	return ordernum;
}
public void setOrdernum(int ordernum) {
	this.ordernum = ordernum;
}

}
