package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.lucene.service.impl.IndexDaoServiceImpl;

import com.shopping.lucene.util.SearchResult;

public class SearchGoodsServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                String  ptype=  request.getParameter("type_s");
		       String   bargain_s  =  request.getParameter("bargain_s");
		       String newGoods_s  = request.getParameter("newGoods_s");
		       String content_s  = request.getParameter("content_s");
		    
 
		       if(bargain_s==null){
		    	   bargain_s="原价";
		    	   System.out.println(bargain_s);
		       }else{
		    	   bargain_s="特价";
		       }
		       if(newGoods_s!=null){
		    	   newGoods_s="新商品";
		       }
		      StringBuffer   sb = new StringBuffer();
		      sb.append(ptype).append("  ").append(content_s+"  ").append(bargain_s+"    ").append(newGoods_s+"  ");
        SearchResult  searchResult =IndexDaoServiceImpl.getInstance().search(sb.toString(),0, 100);
        System.out.println(searchResult.count);
        request.setAttribute("searchResult", searchResult);
        request.setAttribute("isPageIn","111111111");
        request.getRequestDispatcher("./search_deal.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
       this.doGet(request, response);
       
	}

}
