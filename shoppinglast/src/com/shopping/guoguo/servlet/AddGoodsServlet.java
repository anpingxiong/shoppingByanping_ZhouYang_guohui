package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class AddGoodsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	/*   gid                  int not null auto_increment,
	   name                 varchar(20),
	   marketprice          double,
	   nowprice             double,
	   discount             double,
	   bargain              int,
	   exp                  text,
	   sid                  int,
	   pdate                date,
	   goodsnum             int,
	   ordernum             int,
	 *  */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods good = new Goods();
		good.setName(request.getParameter("name"));
		good.setMarketprice((Double.parseDouble(request.getParameter("marketprice"))));
		good.setNowprice((Double.parseDouble(request.getParameter("nowprice"))));
		
		int discount =(int)(((Double.parseDouble(request.getParameter("nowprice"))) /(Double.parseDouble(request.getParameter("marketprice"))))*10) ;
		good.setDiscount(discount);
		good.setBargain((Integer.parseInt(request.getParameter("bargain"))));
		good.setExp(request.getParameter("exp"));
		good.setSort(SortServiceImpl.getInstance().receiveSortBySid(Integer.parseInt(request.getParameter("smallSort"))));
		good.setPdate(new Date());
		good.setGoodsnum(0);
	    good.setOrdernum(0);
	    
	    GoodsServiceImpl.getInstance().addGoods(good);
	    System.out.println("添加成功！");
	    response.sendRedirect("./manage/GoodsManage.jsp");
	
		
	}

}
