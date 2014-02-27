package com.shopping.guoguo.pojo;

public class Comment {
private int id;
private Goods goods;
private User user;
private String content;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}
