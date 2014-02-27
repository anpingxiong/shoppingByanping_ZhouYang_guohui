package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class UpdateSortServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sort sort = new Sort();
		sort.setSid((Integer.parseInt(request.getParameter("sid"))));
		sort.setName(request.getParameter("name"));
		sort.setExp(request.getParameter("exp"));
		SortServiceImpl.getInstance().updateSortDetail(sort);
		System.out.println("更改本类成功！");
		response.sendRedirect("./manage/ParameterManage.jsp");
		

		
	}

}
