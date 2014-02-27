package com.shopping.anping.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shopping.anping.dao.CommentDao;
import com.shopping.anping.service.CommentService;
import com.shopping.factory.CreateDaoFactory;
import com.shopping.guoguo.pojo.Comment;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.pojo.User;

public class CommentServiceImpl  implements CommentService{
     private CommentServiceImpl(){}
     private static CommentServiceImpl  service= new CommentServiceImpl();
     public   static CommentServiceImpl  getInstance(){
    	 return        service;
     }
     private  static  CommentDao   commentDao = (CommentDao)CreateDaoFactory.createDao("com.shopping.anping.dao.impl.CommentDao");
	public Comment getCommentById(int id) {
	 	return commentDao.findCommentById(id);
	}
 
	public void addComment(Comment comment) {
		commentDao.add(comment);
		
	}
	public List<Comment> getCommentsByPage(PageVo pageVo, int gid) {
		List<Comment> comments =commentDao.findCommendByPage(pageVo.getFirstIndex(), pageVo.getMaxResult(),gid);
		
		return comments;
	}

	public List<Comment> getCommentsByGid(int gid) {
		// TODO Auto-generated method stub
		return commentDao.findcommentByGid(gid);
	}

	
}
