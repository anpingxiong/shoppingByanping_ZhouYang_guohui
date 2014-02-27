package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class LoadAllSortServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");//用到JESON要清除缓存 以免出现错误
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		 response.setDateHeader("Expires",0);
		 response.setHeader("Pragma", "no-cache");
		
		 int pid  =Integer.parseInt(request.getParameter("pid"));
			System.out.println(pid);
			 List<Sort> sorts = SortServiceImpl.getInstance().receiveSortsByPid(pid);
			 StringBuffer bf = new StringBuffer("[");
			 /////////{[id:1,name:"name"],[sid:2,name:"aaa"],[]}
			   try {
				sorts.get(0);
				  for(Sort  sort:sorts){
					 bf.append("{").append("\"sid\":").append(sort.getSid()).append(",").append("\"name\":\"").append(sort.getName()).append("\"").append("}").append(",");
				 }
				 bf.deleteCharAt(bf.length()-1);
		        	bf.append("]");
		        	System.out.println(bf);
			} catch (Exception e) {
				System.out.println("kong");
			}finally{
				PrintWriter  out = response.getWriter();
				if(bf.toString().endsWith("[")){
					bf=null;
				}
				out.print(bf);   //  把bf返回给js
	        	out.flush();
	        	out.close();
			}
	  
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    this.doGet(request, response);
	}

}
