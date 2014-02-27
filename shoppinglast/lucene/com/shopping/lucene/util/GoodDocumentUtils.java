package com.shopping.lucene.util;

 
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

import com.shopping.guoguo.pojo.Goods;
import com.shopping.lucene.dao.impl.GetPPGoodsName;
import com.shopping.util.StringToDate;

public class GoodDocumentUtils {
	 public Goods Document2Good(Document doc){
		 Goods good  = new Goods();
		 if(doc.get("bargain").equals("特价")){
			  good.setBargain(1);
		  } else if(doc.get("bargain").equals("原价")){
			  good.setBargain(0);
		  }
		 
		   good.setGid(Integer.parseInt(doc.get("gid")));
		   good.setName(doc.get("name"));
		   good.setMarketprice(Double.parseDouble(doc.get("marketprice")));
		   good.setNowprice(Double.parseDouble(doc.get("nowprice")));
		   good.setDiscount(Double.parseDouble(doc.get("discount")));
	        good.setExp(doc.get("exp"));
		//我拿到的是他的大类   good.setSort(sort);
		     good.setGoodsnum(Integer.parseInt(doc.get("goodsnum")));
		   good.setOrdernum(Integer.parseInt(doc.get("ordernum")));
		  return good;
	   }
	   public Document Good2Document(Goods good){
		   Document doc  = new Document();
		   if(good.getBargain()==1){
			    String a = "特价";
			   doc.add(new Field("bargain",a,Store.YES,Index.ANALYZED)) ;
		   }else{
			   String b = "原价";
			   doc.add(new Field("bargain",b,Store.YES,Index.ANALYZED)) ;
		   }
	   String  date  =     new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Date  aa  =  null;
	   try {
	  aa  =  StringToDate.parseStringToDate(date);
	} catch (Exception e) {
	 	e.printStackTrace();
	}
	   if(( aa.getTime() - good.getPdate().getTime())<=3){
		     doc.add(new Field("newGoods","新商品",Store.YES,Index.ANALYZED));
		   }
	       doc.add(new Field("gid",good.getGid()+"",Store.YES,Index.NOT_ANALYZED)) ;
	       doc.add(new Field("name",good.getName(),Store.YES,Index.ANALYZED)) ;
	       doc.add(new Field("marketprice",good.getMarketprice()+"",Store.YES,Index.NOT_ANALYZED)) ;
	       doc.add(new Field("nowprice",good.getNowprice()+"",Store.YES,Index.ANALYZED)) ;
	       doc.add(new Field("discount",good.getDiscount()+"",Store.YES,Index.ANALYZED)) ;
	        doc.add(new Field("exp",good.getExp(),Store.YES,Index.ANALYZED));
	       doc.add(new Field("sortName",GetPPGoodsName.getName(good.getSort().getSid()),Store.YES,Index.ANALYZED));
	       doc.add(new Field("pdate",good.getPdate().toString(),Store.YES,Index.ANALYZED));
	       doc.add(new Field("goodsnum",good.getGoodsnum()+"",Store.YES,Index.ANALYZED));
	       doc.add(new Field("ordernum",good.getOrdernum()+"",Store.YES,Index.ANALYZED));
	         return doc;
	   }
}
