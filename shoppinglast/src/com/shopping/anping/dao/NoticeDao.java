
package com.shopping.anping.dao;

import java.util.List;

 import com.shopping.guoguo.pojo.Notice;

public interface NoticeDao {
	public  int  getTotalNotice();
	public void add(Notice notice);
	
	   public  void deleteById(int id);
	   public void update(Notice notice);
	   public Notice  findNoticeById(int id );
	   public   List<Notice> findNoticeByPage(int firstIndex,int maxResult);
	public void checkNoticeIsNotGuoQiToDelte();
}
