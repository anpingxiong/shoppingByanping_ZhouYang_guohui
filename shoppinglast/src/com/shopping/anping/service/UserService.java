package com.shopping.anping.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;

import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.pojo.User;

public interface UserService {
    public void addUser(User user);
    public void deleteUser(int id);
    public void update(User user,String username);
    public User getUserById(int id); 
    public User login(User user);
   public List<User> getUserByPage(PageVo pageVo,HttpServletRequest request);
   public  int modifyUserState(int id,int state);
   public User findUserByOrder(String id,String username);
   public   void  addUserExpense(double expense ,int  uid);
}
