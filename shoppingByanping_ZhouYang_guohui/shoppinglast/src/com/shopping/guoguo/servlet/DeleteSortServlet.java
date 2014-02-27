package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.service.impl.SortServiceImpl;

public class DeleteSortServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sid = (Integer.parseInt(request.getParameter("sid")));
		SortServiceImpl.getInstance().deleteSortBySid(sid);
		System.out.println("删除此类成功");
		request.getRequestDispatcher("./manage/ParameterManage.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

		
	}

}
