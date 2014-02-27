package com.shopping.guoguo.pojo;

import java.util.Date;

public class Notice {
	  private int    id      ;
	  private String title   ;
	  private String content ;
	  private Date   pdate   ;
	  private Date   overdate ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public Date getOverdate() {
		return overdate;
	}
	public void setOverdate(Date overdate) {
		this.overdate = overdate;
	}
	  
}
