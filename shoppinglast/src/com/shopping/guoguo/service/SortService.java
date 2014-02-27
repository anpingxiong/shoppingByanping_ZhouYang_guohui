package com.shopping.guoguo.service;

import java.util.List;

import com.shopping.guoguo.pojo.Sort;

public interface SortService {
	public Sort receiveSortBySid(int sid);
	public List<Sort> receiveSortsByPid(int pid);
	public void updateSortDetail(Sort sort);
	public void deleteSortBySid(int sid);
	public int addSort(Sort sort,int pid);
	
}
