package com.shopping.lucene.util;

import java.util.List;

public class SearchResult<T> {
	  public int count;
	  public List<T> list;
	  public SearchResult(int count,List<T> list){
		  this.count = count;
		  this.list  = list;
	  }
	public int getCount() {
		return count;
	}
 
	public List<T> getList() {
		return list;
	}
 
	}
