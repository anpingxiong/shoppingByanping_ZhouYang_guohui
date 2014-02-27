package com.shopping.zhouyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class CartAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             
		int gid = Integer.parseInt(request.getParameter("gid"));
		
		Cookie[] cookies = request.getCookies();

		// cookie[0]是JSID的，不是添加的数据
		if (cookies.length == 1) {

			Cookie cookie = new Cookie(gid + "", "1");
			response.addCookie(cookie);

		} else {

			boolean flag = false;
			// 判断当前的商品是否被购买过，假设原来没有购买过
			int index = 0;
			// 如果原来已经购买过，index为这个商品在cookie中的下标

			for (int i = 1; i < cookies.length; i++) {

				if (cookies[i].getName().equals(gid + "")) {

					index = i;
					// 得到这个cookie[i]
					flag = true;
					// 判断为以购买过
					break;
				}

			}

			if (flag) {

				int count = Integer.parseInt(cookies[index].getValue());

				Cookie cookie = new Cookie(cookies[index].getName(), ++count
						+ "");

				response.addCookie(cookie);

			} else {
				Cookie cookie = new Cookie(gid + "", "1");
				response.addCookie(cookie);

			}
		}

		
		
		
//		request.getRequestDispatcher("./cartShow.do").forward(request,
//				response);
		response.sendRedirect("./cartShow.do");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
