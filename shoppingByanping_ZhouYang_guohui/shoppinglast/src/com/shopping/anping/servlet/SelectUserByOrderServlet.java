package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.pojo.User;

public class SelectUserByOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");

		String id = request.getParameter("id");
		String username = request.getParameter("username");

		if (id.equals("")) {
			id = null;
		}
		if (username.equals("1")) {
			username = null;
		}
		User user = UserServiceImpl.getInstance().findUserByOrder(id, username);

		StringBuffer sb = new StringBuffer("[");
		// 迭代我们的users数据 [{id:1,name:'2'}]
		sb.append("{").append("uid:").append(user.getUid()).append(",")
				.append("username:\"").append(user.getUsername()).append("\"")
				.append(",").append("name:\"").append(user.getName())
				.append("\"").append(",").append("email:\"")
				.append(user.getEmail()).append("\"").append(",")
				.append("expense:").append(user.getExpense()).append(",")
				.append("level:\"")
				.append((user.getLevel() == 0 ? ("普通会员") : ("vip")))
				.append("\"").append(",").append("pdate:\"")
				.append(user.getPdate()).append("\"").append(",")
				.append("state:").append(user.getState()).append("}")
				.append("]");
		PrintWriter out = response.getWriter();
		if (sb.toString().equals("[")) {
			sb = null;
		}
		System.out.println(sb);
		out.print(sb);
		out.flush();
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
