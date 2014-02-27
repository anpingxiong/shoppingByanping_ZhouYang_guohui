package com.shopping.anping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.anping.service.impl.FavoriteServiceImpl;
import com.shopping.guoguo.pojo.Favortie;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.User;
import com.shopping.guoguo.service.impl.GoodsServiceImpl;

public class AddFavoriteServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            int gid  = Integer.parseInt(request.getParameter("gid"));
          System.out.println(gid+"vvvvvvvvvvvvvvvvvvvvvvvv");
            User user  = (User)  request.getSession().getAttribute("user");
              
             Goods  good  =   GoodsServiceImpl.getInstance().receiveGoodByGid(gid);
              
             Favortie  favorite   = new Favortie();
               favorite.setUser(user);
               favorite.setGoods(good);
               PrintWriter   out  = response.getWriter();
              String result =null ;
              Favortie    favorite_2  = FavoriteServiceImpl.getInstatnce().checkFavoriteIsIn(favorite);
               if(favorite_2!=null){
            	   result="亲,"+good.getName()+"早已收藏哦！！";
              }else{
               FavoriteServiceImpl.getInstatnce().addFavorite(favorite);
                result =good.getName()+ " 收藏成功!";
              } 
              out.print(result);
             out.flush();
             out.close();
               
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
