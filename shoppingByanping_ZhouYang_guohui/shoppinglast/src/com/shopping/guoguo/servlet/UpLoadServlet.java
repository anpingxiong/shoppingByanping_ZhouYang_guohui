package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class UpLoadServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 SmartUpload upload  = new SmartUpload();
		 upload.initialize(this.getServletConfig(), request, response);
		 upload.setCharSet("UTF-8");
		 try {
			upload.upload(); 
			Request req   = upload.getRequest();
			
			
			String name   = req.getParameter("name");
			double marketprice = Double.parseDouble(req.getParameter("marketprice"));
			double   nowprice  = Double.parseDouble(req.getParameter("nowprice"));
			int discount =(int)(nowprice/marketprice*10) ;
			int bargain = Integer.parseInt(req.getParameter("bargain"));
			String exp = req.getParameter("exp");
			Sort sort = SortServiceImpl.getInstance().receiveSortBySid(Integer.parseInt(req.getParameter("smallSort")));
		 	Goods good = new Goods();
			good.setName(name);
			good.setMarketprice(marketprice);
			good.setNowprice(nowprice);
			good.setDiscount(discount);
			good.setBargain(bargain);
			good.setExp(exp);
			good.setSort(sort);
			good.setPdate(new Date());
			good.setGoodsnum(0);
		    good.setOrdernum(0);
		    
		  
			Files files = upload.getFiles();
			File  file   = files.getFile(0);
		  	
			file.saveAs(".//images//goods//"+name+".jpg");
			 GoodsServiceImpl.getInstance().addGoods(good);
		} catch (SmartUploadException e) {
			 e.printStackTrace();
		}finally{
		 
		    System.out.println("添加成功！");
		    response.sendRedirect("./manage/GoodsManage.jsp");
		}
	}

}
