package com.shopping.anping.dao;

import java.util.List;

import com.shopping.guoguo.pojo.Comment;

public interface CommentDao {
   public void add(Comment comment);
   public  void deleteById(int id);
   public Comment  findCommentById(int id );
   public   List<Comment> findCommendByPage(int firstIndex,int maxResult,int gid);
  public List<Comment>  findcommentByGid(int gid);
}
