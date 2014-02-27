package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class AddSortsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sort sort = new Sort();
	     System.out.println(request.getParameter("pid")+"2222222222");
		int pid = (Integer.parseInt(request.getParameter("pid")));
	
		//sort.setPid(SortServiceImpl.getInstance().receiveSortBySid((Integer.parseInt(request.getParameter("pid")))));
		sort.setName(request.getParameter("name"));
		sort.setExp(request.getParameter("exp"));
		int flag = SortServiceImpl.getInstance().addSort(sort, pid);
		if(flag==1){
			System.out.println("添加本类成功！");
			response.sendRedirect("./manage/ParameterManage.jsp");
		}else{
			System.out.println("添加本类失败！");
		}

	}

}
