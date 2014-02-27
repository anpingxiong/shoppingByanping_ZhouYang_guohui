package com.shopping.guoguo.pojo;

public class Sort {
private int sid;
private String name;
private String exp;
private Sort parent;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getExp() {
	return exp;
}
public void setExp(String exp) {
	this.exp = exp;
}
public Sort getPid() {
	return parent;
}
public void setPid(Sort parent) {
	this.parent = parent;
}

}
