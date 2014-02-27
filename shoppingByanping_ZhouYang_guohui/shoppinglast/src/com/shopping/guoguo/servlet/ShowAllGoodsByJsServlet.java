package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class ShowAllGoodsByJsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int totalCount   =   GoodsServiceImpl.getInstance().receiveGoodsCountPage(0);
	   int   totalPage = (totalCount %6) == 0 ? (totalCount / 6): (totalCount / 6 + 1);
      List<Goods>   goods  = GoodsServiceImpl.getInstance().receiveAllGoods();
	  StringBuffer    sb  = new StringBuffer("[");
      for(Goods  good  : goods){
			sb.append("{\"gid\":").append(good.getGid()).append(",").append("\"name\":\"")
			.append(good.getName()).append("\"").append(",").append("\"type\":\"")
			.append(SortServiceImpl.getInstance().receiveSortBySid(good.getSort().getSid()).getName())
			.append("\"").append(",").append("\"nowPrice\":\"").append(good.getNowprice()).append("\"")
			.append(",").append("\"goodsnum\":\"").append(good.getGoodsnum()).append("\"").append(",")
			.append("\"ordernum\":\"").append(good.getOrdernum()).append("\"").append(",").append("\"bargain\":\"")
			.append(good.getBargain()).append("\"").append(",").append("\"totalPage\":\"").append(totalPage).append("\"").append("}").append(",");
		 	 } 
      sb.deleteCharAt(sb.length()-1);
      sb.append("]");
       System.out.println(sb);
      out.print(sb);
		out.flush();
		out.close();
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 this.doGet(request, response);
	}

}
