package com.shopping.lucene.service;

import com.shopping.lucene.util.SearchResult;

 
public interface IndexDaoService {
      public SearchResult search(String queryString,int firstIndex,int maxResult);
}
