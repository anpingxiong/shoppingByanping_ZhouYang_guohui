package com.shopping.guoguo.dao;

import java.util.List;

import com.shopping.guoguo.pojo.Goods;

public interface GoodsDao {
	//分页
	public List<Goods> getGoodsByPage(int firstIndex,int MaxResult,int tag);
	//select
	
	public List<Goods> getAllGoods();
	public Goods getGoodByGid(int gid);
	public Goods getGoodByName(String name);
	public List<Goods> getBargainGoods();
	public List<Goods> getNewGoods();
	public List<Goods> getThisPageGoods();//获得本页的所有goods
	public int updateGoodsnum(int goodsNum ,String goodsName);
	public List<Goods> getGoodsSale();
	public int getGoodsCountPage(int tag);
	//alter
	public int alterGoods(Goods good);
	public void updateNumOrdered(int gid,int num,boolean tag);
	//add
	public void insertGoods(Goods good);
	//delete
	public int deleteGoods(int gid);
	//search
	 public  List<Goods> getGoodsByPPerentOrName(int id,String name);
 
}
