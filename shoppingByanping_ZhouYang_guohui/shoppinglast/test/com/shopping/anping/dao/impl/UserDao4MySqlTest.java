package com.shopping.anping.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.User;

public class UserDao4MySqlTest extends UserDao4MySqlImpl {

	 @Test
	public void addUserTest() {
	    for(int i = 0;i<20;i++){
	    	User user =  new User();
	    	user.setUsername("anping"+i);
	    	user.setPassword("a123456");
	    	user.setEmail("973983"+i+"@qq.com");
	    	user.setName("熊安平"+i);
	    	user.setAddress("农大"+i);
	    	user.setProvince("江西");
	    	user.setCity("宜春");
	    	user.setUrban("奉新");
	    	user.setPost("330701");
	    	user.setTel("18779883891");
	    	user.setExpense(0.0);
	    	user.setLevel(0);
	    	user.setState(1);
	    	user.setPdate(new Date());
	    	new UserDao4MySqlImpl().add(user);
	    }
	}
	 @Test  
	 public void  selectUserTest(){
		
	   }

}
