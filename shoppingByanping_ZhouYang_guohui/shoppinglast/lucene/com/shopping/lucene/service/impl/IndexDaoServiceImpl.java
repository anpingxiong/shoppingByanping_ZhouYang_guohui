package com.shopping.lucene.service.impl;

import com.shopping.lucene.dao.impl.IndexDaoImpl;
import com.shopping.lucene.service.IndexDaoService;
import com.shopping.lucene.util.SearchResult;

 
public class IndexDaoServiceImpl implements IndexDaoService{
     private IndexDaoServiceImpl(){}
     private static IndexDaoServiceImpl service = new IndexDaoServiceImpl();
     private static IndexDaoImpl   dao= new IndexDaoImpl();
     public static  IndexDaoServiceImpl getInstance(){
    	    return service;
     }
	public SearchResult search(String queryString, int firstIndex, int maxResult) {
	 	return dao.search(queryString, firstIndex, maxResult);
	}

}
