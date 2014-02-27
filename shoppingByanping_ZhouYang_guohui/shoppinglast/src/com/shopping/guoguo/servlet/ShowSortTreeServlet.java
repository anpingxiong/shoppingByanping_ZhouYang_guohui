package com.shopping.guoguo.servlet;

import java.io.IOException;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Sort;
import com.shopping.guoguo.pojo.SortVo;
import com.shopping.guoguo.service.impl.SortServiceImpl;

public class ShowSortTreeServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      String  url   =  request.getParameter("url");
		List<Sort> sorts  = SortServiceImpl.getInstance().receiveSortsByPid(0);
       List<SortVo> sortVos =  new ArrayList<SortVo>();
       for(Sort  sort:sorts){
    	   SortVo  sortvo   = new SortVo();
    	   sortvo.setPsort(sort);
    	   sortVos.add(sortvo);
       }
       System.out.println("111111111");
     request.setAttribute("sortVos", sortVos);
     request.getRequestDispatcher(url).forward(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

this.doGet(request, response);
	}

}
