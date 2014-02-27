package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class ShowModifiedSmallSortServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("已进入呈现被修改的小类方法");
		int sid =(Integer.parseInt( request.getParameter("sid")));
		Sort sort = SortServiceImpl.getInstance().receiveSortBySid(sid);
		request.setAttribute("sort", sort);
		request.getRequestDispatcher("./manage/smallSorts_modify.jsp").forward(request, response);


		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
