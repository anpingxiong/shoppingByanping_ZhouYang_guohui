package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.User;

public class ModifyUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String truename = request.getParameter("truename");
		String address = request.getParameter("address");
		String province = request.getParameter("province");
		String city1 = request.getParameter("city1");
		String city2 = request.getParameter("city2");
		String post = request.getParameter("post");
		User user_2  = (User) request.getSession().getAttribute("user");
	 	if(password == null){
			password= user_2.getPassword();
		}
		if(province.equals("请选择")){
	 	province   =   user_2.getProvince() ;
		city1=  user_2.getCity();
		city2=  user_2.getUrban();
		}
		String telephone = request.getParameter("telephone");
		User user   = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setName(truename);
		user.setAddress(address);
		user.setProvince(province);
		user.setCity(city1);
		user.setUrban(city2);
		user.setPost(post);
		user.setTel(telephone);
		User user2   =(User) request.getSession().getAttribute("user");
		user.setExpense(user2.getExpense());
		user.setLevel(user2.getLevel());
		user.setState(user2.getState());
		user.setPdate(user2.getPdate());
	 
	 
	   //调用删除
		UserServiceImpl.getInstance().update(user,user2.getUsername());
		request.getSession().removeAttribute("user");
	 PrintWriter   out   =   response.getWriter();
	 out.print("修改成功,请重新登录");
	 out.flush();
	 out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
