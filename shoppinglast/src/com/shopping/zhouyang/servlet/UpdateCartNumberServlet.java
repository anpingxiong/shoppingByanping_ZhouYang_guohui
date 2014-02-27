package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class UpdateCartNumberServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 	response.setContentType("text/html");
	        response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store");
			response.setDateHeader("Expires",0);
			response.setHeader("Pragma", "no-cache");
		
		String name =	request.getParameter("name");
		int num =Integer.parseInt(request.getParameter("num"));
		Cookie[] cookies= request.getCookies();
	
		Goods good = new Goods();
		good = GoodsServiceImpl.getInstance().receiveGoodByName(name);
		int gid = good.getGid();
		//判断当前购买数量要小于商品的数量
		int currentnum = good.getGoodsnum()-good.getOrdernum();
	String str = null;
		if(num<currentnum){	

		Cookie cookie = new Cookie(gid+"",num+"");
		response.addCookie(cookie);

				str =	"修改成功！";
		}else{
			str =  "库存不足，请购买小于"+currentnum+"件的商品！";
	    }
	
		
		PrintWriter   out = response.getWriter();
		out.print(str);
	     out.flush();
	     out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
