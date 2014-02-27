package com.shopping.anping.servlet;


import java.io.*;
import java.util.*;
import com.sun.image.codec.jpeg.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;

/**
 * Title: getImg.java Description: 这个class主要实现随机生成一个4位数的验证码，并写入session，
 * Copyright: Copyright (c) 2003 Company: 蓝星软件
 * 
 * @author falcon
 * @version 1.1
 */

public class CheckNumServlet extends HttpServlet {

	private Font mFont = new Font("宋体", Font.PLAIN, 12);// 设置字体

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得一个1000-9999的随机数
		 
		String s = "";

		int intCount = 0;

		intCount = (new Random()).nextInt(9999);//

		if (intCount < 1000)
			intCount += 1000;

		s = intCount + "";

		// 对session付值。

		HttpSession session = request.getSession(true);
      
		session.setAttribute("getImg", s);
System.out.println(s);
		response.setContentType("image/gif");

		ServletOutputStream out = response.getOutputStream();

		BufferedImage image = new BufferedImage(35, 14,
				BufferedImage.TYPE_INT_RGB);

		Graphics gra = image.getGraphics();
		// 设置背景色
		gra.setColor(Color.yellow);

		gra.fillRect(1, 1, 33, 12);
		// 设置字体色
		gra.setColor(Color.black);

		gra.setFont(mFont);
		// 输出数字
		char c;

		for (int i = 0; i < 4; i++) {

			c = s.charAt(i);

			gra.drawString(c + "", i * 7 + 4, 11); // 7为宽度，11为上下高度位置

		}

		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

		encoder.encode(image);

		out.close();

	}

	// 处理post
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}


