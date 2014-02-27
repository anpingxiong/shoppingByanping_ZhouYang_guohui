package com.shopping.guoguo.pojo;

import java.util.List;

import com.shopping.guoguo.dao.impl.SortDao4MySqlImpl;

public class SortVo {
   private   Sort psort ;
   private List<Sort> csort;
public Sort getPsort() {
	return psort;
}
public void setPsort(Sort psort) {
this.csort= 	new SortDao4MySqlImpl().findSortsByPid(psort.getSid());
	this.psort = psort;
}
public List<Sort> getCsort() {
	return csort;
}

}
