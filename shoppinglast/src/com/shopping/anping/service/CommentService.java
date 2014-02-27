package com.shopping.anping.service;

import java.util.List;

import com.shopping.guoguo.pojo.Comment;
import com.shopping.guoguo.pojo.PageVo;

public interface CommentService {
  public  Comment getCommentById(int id);
  public  void addComment(Comment comment);
  public List<Comment>  getCommentsByPage(PageVo pageVo,int gid);
  public List<Comment> getCommentsByGid(int gid);
}
