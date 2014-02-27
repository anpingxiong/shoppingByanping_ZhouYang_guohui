package com.shopping.guoguo.servlet;

import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class ShowGoodsSaleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		List<Goods> saleGoods = GoodsServiceImpl.getInstance().receiveGoodsSale();  
		StringBuffer   sb  =  new StringBuffer("[");
		for(Goods goods:saleGoods){
			sb.append("{\"gid\":").append(goods.getGid()).append(",").append("\"name\":").append("\""+goods.getName()+"\"").append("}")
			.append(",");
		}
		 sb.deleteCharAt(sb.length()-1);
		 sb.append("]");
	 PrintWriter   out  =  response.getWriter();
	  if(sb.equals("[")){
		  sb=null;
	  }
	  out.print(sb);
	 out.flush();
	 out.close();
		

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

		
	}

}
