package com.shopping.guoguo.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shopping.factory.CreateDaoFactory;
import com.shopping.guoguo.dao.GoodsDao;
import com.shopping.guoguo.dao.impl.GoodsDao4MySqlImpl;
import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.PageVo;
import com.shopping.guoguo.service.GoodsService;
import com.shopping.lucene.dao.impl.IndexDaoImpl;
import com.shopping.util.GetLogger;

public class GoodsServiceImpl implements GoodsService {
	private GoodsServiceImpl(){}
	//注意！这里要强转 并且要写包的全名
	private static GoodsDao goodsDao =(GoodsDao) CreateDaoFactory.createDao("com.shopping.guoguo.dao.impl.GoodsDao");
	private static GoodsService goodsService =new GoodsServiceImpl();
	public static GoodsService getInstance(){
		return goodsService;
	}

	public List<Goods> receiveAllGoods() {
		
		return goodsDao.getAllGoods();
		
	}

	public Goods receiveGoodByGid(int gid) {
		
		return goodsDao.getGoodByGid(gid);
	}

	public int modifyGoods(Goods good) {
		 new IndexDaoImpl().update(good);
		return goodsDao.alterGoods(good);
		//记录日志
	     // GetLogger.getLogger().warn(good.getName()+"修改成功");

	}

	public void addGoods(Goods good) {
		goodsDao.insertGoods(good);
              new IndexDaoImpl().save(good);
	}

	public int removeGoods(int gid) {
		 new IndexDaoImpl().delete(gid);
		return goodsDao.deleteGoods(gid);
		
	}

	public Goods receiveGoodByName(String name) {
		
		return goodsDao.getGoodByName(name);
	}

	public List<Goods> receiveBargainGoods() {
		// TODO Auto-generated method stub
		return goodsDao.getBargainGoods();
	}

	public int renewGoodsnum(int goodsNum,String goodsName) {
		
		return goodsDao.updateGoodsnum(goodsNum, goodsName);
	}

	public List<Goods> receiveNewGoods() {
		
		return goodsDao.getNewGoods();
	}

	public List<Goods> receiveGoodsSale() {
		
		return goodsDao.getGoodsSale();
	}

	public List<Goods> receiveGoodsByPage(PageVo pageVo,int tag) {
		//注意 这方法里的参数  通过pageVO获得
		List<Goods> goodsPage = goodsDao.getGoodsByPage(pageVo.getFirstIndex(), pageVo.getMaxResult(),tag);
		 
		//这里返回的是分页之后的goods
		return goodsPage;
		
	}

	public int receiveGoodsCountPage(int tag) {
		
		return goodsDao.getGoodsCountPage(tag);
	}

	public void alterNumOrdered(int gid, int num,boolean tag) {
		 goodsDao.updateNumOrdered(gid, num,tag);
		
	}

	public List<Goods> getGoodsOrder(int id, String name) {
	 return goodsDao.getGoodsByPPerentOrName(id, name);
	}


}
