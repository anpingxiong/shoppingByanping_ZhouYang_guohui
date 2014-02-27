package com.shopping.anping.dao;

import java.util.List;

import com.shopping.guoguo.pojo.User;
 public interface UserDao {
	 public   User   selectUserByOrder(String id,String username);
   public  User  findUserById(int id);  
   public  int   add(User user);  
   public   void deleteUserById(int id);  
   public   void deleteUserByUsername(String  username);  
   public void updateUserById(User user,String username);   
   public   List<User> getAllUsers();
   public User findUserByName(String username);
  public  List<User> findUserByPage(int firstIndex,int MaxResult);
  public int   getUserTotal();
  public int  modifyUserState(int uid,int state);
    public  void   addUserExpense(double  expense,int uid );
    public void    modifyUserLevel(int id );
    public   Double    getUserExpense(int id );
 }
