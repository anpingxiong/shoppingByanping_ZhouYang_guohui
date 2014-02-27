package com.shopping.anping.service.impl;

 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shopping.anping.dao.UserDao;
import com.shopping.anping.exception.PassWordErrorException;
import com.shopping.anping.exception.UserNotExsitsException;

import com.shopping.anping.service.UserService;

import com.shopping.factory.CreateDaoFactory;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.pojo.User;
import com.shopping.util.GetLogger;


public class UserServiceImpl implements UserService {
   
	 private UserServiceImpl (){}
	 private static UserServiceImpl service= new UserServiceImpl();
    private  static UserDao userDao =  (UserDao) CreateDaoFactory.createDao("com.shopping.anping.dao.impl.UserDao");
	public static UserServiceImpl getInstance (){
		return service;
	}
	public void addUser(User user) {
		   userDao.add(user);
      GetLogger.getLogger().warn(user.getName()+"添加成功");
	}

	public void deleteUser(int id) {
	 userDao.deleteUserById(id);
	User user = userDao.findUserById(id);
	 GetLogger.getLogger().warn(user.getName()+"删除成功");
	}   

	public void update(User user,String username) {
      userDao.updateUserById(user,username);
     }

	public User getUserById(int id) {
	     return userDao.findUserById(id);
		
	}
	public String checkUsername(String name){
		 User user =null; 
			user=	 userDao.findUserByName(name);
			if(user==null){
				return "√";
			}else{
				return "用户已存在";
			}
		 
	}
	public User login(User user) {
		  User user_2 = null;
		 user_2=userDao.findUserByName(user.getUsername());
		if(user_2==null){
			throw new UserNotExsitsException();
		}else if(!user_2.getPassword().equals(user.getPassword())){
			throw new PassWordErrorException();
		}
		return user_2;
	}
 
	public int modifyUserState(int id, int state) {
		 
	return 	userDao.modifyUserState(id, state);
	}
	public List<User> getUserByPage(PageVo pageVo, HttpServletRequest request) {
		 List<User> users = userDao.findUserByPage(pageVo.getFirstIndex(), pageVo.getMaxResult());
	       pageVo.setTotalResult( userDao.getUserTotal())  ;
	    
	     return users;
	}
	public User findUserByOrder(String id, String username) {
	 	return userDao.selectUserByOrder(id, username);
	}
	public void addUserExpense(double expense, int uid) {
		   userDao.addUserExpense(expense, uid);
	}
 
 

}
