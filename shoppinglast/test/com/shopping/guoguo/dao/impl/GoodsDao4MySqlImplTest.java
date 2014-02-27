package com.shopping.guoguo.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.guoguo.pojo.Sort;

public class GoodsDao4MySqlImplTest {

	@Test
	public void testgetAllGoods() {
		List<Goods> goods = new GoodsDao4MySqlImpl().getAllGoods();
		System.out.println(goods.get(1).getExp());
	}

	@Test
	public void testgetGoodByGid() {
		int gid = 1;
		Goods good = new GoodsDao4MySqlImpl().getGoodByGid(gid);
		System.out.println(good.getPdate());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	}
	
	@Test
	public void testalterGoods() {
		Goods good = new Goods();
		
		//直接定义为sid等于6
		 int gid = 1;
		
		good.setName("修改后何达电视");
		good.setMarketprice(230);
		good.setNowprice(200);
		good.setDiscount(69);
		good.setBargain(1);
		good.setExp("画面清晰 超值哦");
		//暂时先不修改sort good.setSort(new SortDao4MySqlImpl().getSortBySid(6));
		good.setPdate(new Date());
		good.setGoodsnum(200);
		good.setOrdernum(100);
		
		new GoodsDao4MySqlImpl().alterGoods(good);
		
	}
	/*   gid                  int not null auto_increment,
	   name                 varchar(20),
	   marketprice          double,
	   nowprice             double,
	   discount             double,
	   bargain              int,
	   exp                  text,
	   sid                  int,
	   pdate                date,
	   goodsnum             int,
	   ordernum             int,
	 *  */
	@Test
	public void testinsertGoods() {
		Goods good = new Goods();
		Sort sort = new Sort();
		sort.setSid(2);
		good.setName("吖吖冰箱");
		good.setMarketprice(330);
		good.setNowprice(200);
		good.setDiscount(79);
		good.setBargain(1);
		good.setExp("节能王冰箱");
		good.setSort(sort);//先不管他的类型吗？
		good.setPdate(new Date());
		good.setGoodsnum(200);
		good.setOrdernum(100);
			new GoodsDao4MySqlImpl().insertGoods(good);
	}
	@Test
	public void testdeleteGoods() {
		int gid = 1;
		new GoodsDao4MySqlImpl().deleteGoods(gid);
	}
	@Test
	public void testgetGoodsByName(){
		String name="联想电视";
		Goods good = new GoodsDao4MySqlImpl().getGoodByName(name);
		System.out.println(good.getMarketprice());
	}
	
	@Test
	public void testgetGoodsByPage(){
		int tag=1;
		List<Goods> goods  =  (List<Goods>)new GoodsDao4MySqlImpl().getGoodsByPage(2, 3, tag);
		System.out.println(goods.get(1).getGid());
	}
	
	@Test
	public void testgetCountGoodsPage(){
		int tag=0;
		System.out.println(new GoodsDao4MySqlImpl().getGoodsCountPage(tag));
		
	}
}
