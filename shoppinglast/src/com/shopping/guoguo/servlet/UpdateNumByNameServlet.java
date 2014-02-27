package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;
import com.shopping.lucene.dao.impl.IndexDaoImpl;

public class UpdateNumByNameServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//从页面接受一个商品的name，
	    String goodName  =  request.getParameter("goodName");
		 int goodNum   = Integer.parseInt(request.getParameter("goodNum"));
	     int nowNum   =    Integer.parseInt(request.getParameter("nowNum"));
	     //修改之后的商品数量
	     int modifyNum  = goodNum+nowNum;
	     GoodsServiceImpl.getInstance().renewGoodsnum(modifyNum, goodName);
	    Goods  goods  = new Goods();
	    goods=   GoodsServiceImpl.getInstance().receiveGoodByName(goodName);
	    new IndexDaoImpl().update(goods);
	    //响应回去一个print提示     
	    out.print("修改数量成功-"+goodName+":"+modifyNum+"+(件)");
		out.flush();
		out.close();
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       this.doGet(request, response);
	}

}
