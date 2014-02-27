package com.shopping.guoguo.pojo;

import java.util.Date;


public class Order {
private String oid;
private Date odate;
private double total;
private int payway;
private int billinfo;
private int getmethod;
private int timereq;
private String exp;
private User user;
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
private int state ;
public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public Date getOdate() {
	return odate;
}
public void setOdate(Date odate) {
	this.odate = odate;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
 
public int getBillinfo() {
	return billinfo;
}
public int getPayway() {
	return payway;
}
public void setPayway(int payway) {
	this.payway = payway;
}
public int getGetmethod() {
	return getmethod;
}
public void setGetmethod(int getmethod) {
	this.getmethod = getmethod;
}
public void setBillinfo(int billinfo) {
	this.billinfo = billinfo;
}
 
public int getTimereq() {
	return timereq;
}
public void setTimereq(int timereq) {
	this.timereq = timereq;
}
public String getExp() {
	return exp;
}
public void setExp(String exp) {
	this.exp = exp;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
