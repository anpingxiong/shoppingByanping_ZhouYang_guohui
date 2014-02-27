package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class DeleteGoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gid = (Integer.parseInt(request.getParameter("gid")));
 
		int flag = GoodsServiceImpl.getInstance().removeGoods(gid);
    String  result  = null;
  PrintWriter   out   =  response.getWriter();		
 if(flag==1){
	 
			result="删除成功";
			//在这里要跳出一个alert提示框 提示删除成功
      	return;
		}else{
			result="删除失败";
			//在这里要跳出一个alert提示框 提示删除失败
 }
      out.print(result);
		out.flush();
		out.close();
	}

}
