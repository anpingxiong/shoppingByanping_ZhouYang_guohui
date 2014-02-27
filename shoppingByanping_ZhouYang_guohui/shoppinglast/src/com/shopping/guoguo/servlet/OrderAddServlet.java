package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.anping.service.impl.UserServiceImpl;
import com.shopping.guoguo.pojo.Address;
import com.shopping.guoguo.pojo.Order;
import com.shopping.guoguo.pojo.Orderitem;
import com.shopping.guoguo.pojo.User;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;
import com.shopping.util.NameUtil;
import com.shopping.zhouyang.service.impl.AddressServiceImpl;
import com.shopping.zhouyang.service.impl.OrderServiceImpl;
import com.shopping.zhouyang.service.impl.OrderitemServiceImpl;

public class OrderAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String oid = NameUtil.createOId();

		int payway = Integer.parseInt(request.getParameter("payway"));
		int billinfo = Integer.parseInt(request.getParameter("billinfo"));
		int getmethod = Integer.parseInt(request.getParameter("getmethod"));
		int timereq = Integer.parseInt(request.getParameter("timereq"));
		String exp = request.getParameter("exp");

		Order order = new Order();
		order.setOid(oid);
		order.setOdate(new Date());
		order.setTotal(0);
		order.setPayway(payway);
		order.setBillinfo(billinfo);
		order.setGetmethod(getmethod);
		order.setTimereq(timereq);
		order.setExp(exp);
		order.setUser(user);
		order.setState(1);

		int result = OrderServiceImpl.getInstance().addOrder(order);
		// 初始化所有商品总价
		Double total = 0.0;

		String getname = request.getParameter("name").trim();
			
		String getaddress = request.getParameter("address").trim();

		String post = request.getParameter("post").trim();

		String tel = request.getParameter("tel").trim();
		Address address = new Address();
		
		address.setGetname(getname);
		address.setAddress(getaddress);
		address.setPost(post);
		address.setTel(tel);
		address.setOrder(order);

		AddressServiceImpl.getInstance().addAddress(address);

		if (result == 1) { // 判断添加订单成功
			Cookie[] cookies = request.getCookies();

			// 如果cookie不为空，并且cookie长度大于1
			if (cookies != null && cookies.length > 1) {
				for (int i = 1; i < cookies.length; i++) {
					int gid = Integer.parseInt(cookies[i].getName());
					
					int num = Integer.parseInt(cookies[i].getValue());
					GoodsServiceImpl.getInstance().alterNumOrdered(gid, num,true);
					// 通过商品id取得商品单价
					Double nowprice = GoodsServiceImpl.getInstance()
							.receiveGoodByGid(gid).getNowprice();
					// 取得此件商品的购买数量，即cookie中的数量
					int number = Integer.parseInt(cookies[i].getValue());
					// 计算每样商品的金额总数
					Double everytotal = nowprice * number;
					// 拿到所有商品总价叠加
					total = total + everytotal;
					// 添加一个订单项
					Orderitem orderitem = new Orderitem();
					orderitem.setOrder(order);
					orderitem.setGoods(GoodsServiceImpl.getInstance()
							.receiveGoodByGid(gid));
					orderitem.setNum(num);
					
					int a =OrderitemServiceImpl.getInstance().addOrderitem(orderitem);
					
					//提交订单即把cookie中的数据存入表中，并且清空cookies
					if(a==1){
						try 
						{ 
						for(int j=0;j<cookies.length;j++) 
						{ 
						Cookie cookie = new Cookie(cookies[j].getName(),null); 
						cookie.setMaxAge(0); 
						//cookie.setPath("/");//根据你创建cookie的路径进行填写 
						response.addCookie(cookie); 
						} 
						}catch(Exception ex) 
						{ 
						System.out.println("清空Cookies发生异常！"); 
						} 
					}
				}
				OrderServiceImpl.getInstance().updateOrderByOid(oid, total);
				

			}
		}
		// 跳转
		// request.getRequestDispatcher("./showUserOrder.do").forward(request,
		// response);
		response.sendRedirect("./showUserOrder.do");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
