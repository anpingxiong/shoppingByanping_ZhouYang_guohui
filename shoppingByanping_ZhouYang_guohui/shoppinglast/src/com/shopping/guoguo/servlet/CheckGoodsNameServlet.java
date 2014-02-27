package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class CheckGoodsNameServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		 response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store");
			response.setDateHeader("Expires",0);
			response.setHeader("Pragma", "no-cache");
		String name = request.getParameter("name");
		 Goods good = GoodsServiceImpl.getInstance().receiveGoodByName(name);
		 PrintWriter out = response.getWriter();
			String str =null;
		 if(good==null){
			str="<font color='orange'>√</font>";
		}else{
			str   ="<font color='red'>商品名已经存在</font>";
		 
		}
		 out.print(str);
		out.flush();
		out.close();

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
