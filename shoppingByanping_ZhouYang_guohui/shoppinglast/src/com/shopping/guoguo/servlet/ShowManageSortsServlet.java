package com.shopping.guoguo.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class ShowManageSortsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = (Integer.parseInt(request.getParameter("pid")));
		Sort bigSort = SortServiceImpl.getInstance().receiveSortBySid(pid);
		List<Sort> sorts = SortServiceImpl.getInstance().receiveSortsByPid(pid);
		//这里获得的sorts都是传来的大分类的子类
		request.setAttribute("sorts", sorts);
		request.setAttribute("bigSort", bigSort);
		request.getRequestDispatcher("./manage/subType.jsp").forward(request, response);
		return;
		
		

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
