package com.shopping.guoguo.dao;

import java.util.List;

 
import com.shopping.guoguo.pojo.Sort;

public interface SortDao {
//select
//一个通过大类的id获得所有的children小类
public Sort getSortBySid(int sid);
public List<Sort> findSortsByPid(int pid);
//add
public int insertSort(Sort sort,int pid);
//delete
public void deleteSortBySid(int sid);
//alter
public void alterSortDetail(Sort sort);


}
