package com.shopping.guoguo.service.impl;

import java.util.List;

import com.shopping.guoguo.dao.SortDao;

import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.SortService;
import com.shopping.factory.*;

public class SortServiceImpl implements SortService {
	private SortServiceImpl(){}
	private static SortDao sortDao = (SortDao)CreateDaoFactory.createDao("com.shopping.guoguo.dao.impl.SortDao");
	private static SortService sortService = new SortServiceImpl();
	public static SortService getInstance(){
		return sortService;
	}

	public Sort receiveSortBySid(int sid) {
		
		return sortDao.getSortBySid(sid);
	}


	public List<Sort> receiveSortsByPid(int pid) {
		
		return sortDao.findSortsByPid(pid);
	}

	public void updateSortDetail(Sort sort) {
		 sortDao.alterSortDetail(sort);
		
	}

	public void deleteSortBySid(int sid) {
		sortDao.deleteSortBySid(sid);
		
	}

	public int addSort(Sort sort, int pid) {
		// TODO Auto-generated method stub
		return sortDao.insertSort(sort, pid);
	}


}
