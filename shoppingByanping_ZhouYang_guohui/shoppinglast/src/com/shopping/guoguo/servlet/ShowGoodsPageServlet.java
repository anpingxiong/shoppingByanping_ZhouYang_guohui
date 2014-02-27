package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class ShowGoodsPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//注意 这里要从页面获得两个值 currentPage（用来给vo）和tag（用于区分是哪个前台页面要用到这个方法）
		int currentPage = (Integer.parseInt(request.getParameter("currentPage")));
		int tag =  (Integer.parseInt(request.getParameter("tag")));
		//实例化vo对象 并且填充 注意：totalResult要自己写一个方法获得
		PageVo vo = new PageVo();
		vo.setCurrentPage(currentPage);
		vo.setMaxResult(3);
	    vo.setTotalResult(GoodsServiceImpl.getInstance().receiveGoodsCountPage(tag));
		List<Goods> pgoods = GoodsServiceImpl.getInstance().receiveGoodsByPage(vo, tag);
		request.setAttribute("pgoods", pgoods);
		request.setAttribute("vo", vo);
		//用于判断 需要跳转到的页面
		switch(tag){
		//后台显示所有商品
		case 0:{request.getRequestDispatcher("./manage/GoodsManage.jsp").forward(request, response);} break;
		//特价
		case 1:{request.getRequestDispatcher("./sale.jsp").forward(request, response);}break;
		//新品
		case 2:{request.getRequestDispatcher("./NewGoods.jsp").forward(request, response);}break;
		//销售
		case 3:{request.getRequestDispatcher("./SellSort.jsp").forward(request, response);}break;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request,response);

		
	}

}
