package com.shopping.anping.service.impl;

import java.util.List;

import com.shopping.anping.dao.NoticeDao;
import com.shopping.anping.dao.impl.NoticeDao4MySqlImpl;
import com.shopping.anping.service.NoticeService;
import com.shopping.factory.CreateDaoFactory;
import com.shopping.guoguo.pojo.Comment;
import com.shopping.guoguo.pojo.Notice;
import com.shopping.guoguo.pojo.PageVo;

public class NoticeServiceImpl implements NoticeService {
    private   NoticeServiceImpl(){}
    private static  NoticeServiceImpl service = new NoticeServiceImpl();
    public  static  NoticeServiceImpl  getInstance(){
    	return service;
    }
	private static NoticeDao  noticeDao =(NoticeDao) CreateDaoFactory.createDao("com.shopping.anping.dao.impl.NoticeDao");
	public Notice getNoticeById(int id) {
		 return noticeDao.findNoticeById(id);
	}

	public List<Notice> getNoticesByPage(PageVo pageVo) {
	  
		List<Notice> notices=noticeDao.findNoticeByPage(pageVo.getFirstIndex(), pageVo.getMaxResult());
		
		  pageVo.setTotalResult(noticeDao.getTotalNotice());
		return notices;
	}

	public void updateNotice(Notice notice) {
		noticeDao.update(notice);
	}

	public void deleteNotice(int id) {
	  noticeDao.deleteById(id);
	}

	public void addNotice(Notice notice) {
	noticeDao.add(notice);
	}

	public void checkNoticeOverDate() {
		noticeDao.checkNoticeIsNotGuoQiToDelte();
	}

}
