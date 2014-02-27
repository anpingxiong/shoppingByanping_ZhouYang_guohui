package com.shopping.guoguo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.PageVo;

public interface GoodsService {
	//fenye
	public List<Goods> receiveGoodsByPage(PageVo pageVo,int tag);
	   //select
		public List<Goods> receiveAllGoods();
		public Goods receiveGoodByGid(int gid);
		public Goods receiveGoodByName(String name);
		public List<Goods> receiveBargainGoods();
		public List<Goods> receiveNewGoods();
		public int renewGoodsnum(int goodsNum,String goodName);
		public List<Goods> receiveGoodsSale();
		public int receiveGoodsCountPage(int tag);
		//alter
		public int modifyGoods(Goods good);
		public void alterNumOrdered(int gid,int num,boolean tag);
		//add
		public void addGoods(Goods good);
		//delete
		public int removeGoods(int gid);
		//search
		public List<Goods> getGoodsOrder(int id,String name );
}
