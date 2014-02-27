package com.shopping.anping.service;

import java.util.List;
 
import com.shopping.guoguo.pojo.Notice;
import com.shopping.guoguo.pojo.PageVo;

public interface NoticeService {
	  public  Notice getNoticeById(int id);
	  public List<Notice>  getNoticesByPage(PageVo pageVo);
   public  void  updateNotice(Notice notice);
   public void  deleteNotice(int id );
   public void addNotice(Notice notice);
   public void checkNoticeOverDate();
}
