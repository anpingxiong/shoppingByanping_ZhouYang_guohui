package com.shopping.lucene.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.Version;
import com.anping.configernation.IndexDaoUtil;
import com.anping.configernation.configer;
 
import com.shopping.guoguo.pojo.Goods;
import com.shopping.lucene.util.GoodDocumentUtils;
import com.shopping.lucene.util.SearchResult;


public class IndexDaoImpl {
	//  增
	public void save(Goods good) {
		 //1.我需要將document文件轉換為article
		   //因為多次需要将article  和 document 互转 为此将他们封装成一个工具类类	 
	 	Document  doc  =  new GoodDocumentUtils().Good2Document(good);
		//2.將article加到索引庫中
		//我们将索引库建立必须的目录  和  分词器  封装成类   并且将他们默认是项目启动时创建
try {
		IndexDaoUtil.getIndex().addDocument(doc);
		IndexDaoUtil.getIndex().setMergeFactor(3);
		IndexDaoUtil.getIndex().commit();
	  } catch (Exception e) {
		e.printStackTrace();
	 } 
}

	// 删
	public void delete(int gid) {
		 Term   term =new Term("gid",gid+"");
		//2.將article加到索引庫中
			//我们将索引库建立必须的目录  和  分词器  封装成类   并且将他们默认是项目启动时创建
			try {
			IndexDaoUtil.getIndex().deleteDocuments(term);
			IndexDaoUtil.getIndex().commit();
		  } catch (Exception e) {
			e.printStackTrace();
		 } 
	}

	// 更新
	public void update(Goods good) {
		
		Term   term =new Term("name",good.getName());
		Document doc = new GoodDocumentUtils().Good2Document(good);
		//更新是先删除在创建的方法整合
		try {
			IndexDaoUtil.getIndex().updateDocument(term, doc);
		  } catch (Exception e) {
			e.printStackTrace();
		 }
	}

	// 查(支持分页)  为此为了方便查询我查询出来的结果数量我将article和count封装
public SearchResult search(String queryString,int firstIndex,int maxResult) {
	 //1。将我要查找的东西转化为Query类---需要queryParse  当然是多查找(子类)--在Parse
  	//2。在用IndexSearch查找得到相应的结果  其实即使得到索引目录 再IndexSearch查找
	 
	IndexSearcher indexSearcher=null;
		List<Goods> goods = null;
		int endIndex = 0;
		try {
			goods = new ArrayList<Goods>();
			QueryParser  queryParser = new MultiFieldQueryParser(Version.LUCENE_30,new String[]{"name","sortName","bargain","newGoods"},configer.getAnalyzer());
			Query query  = queryParser.parse(queryString);
			indexSearcher  = new IndexSearcher(configer.getDirectory());
			TopDocs topDocs=	indexSearcher.search(query, firstIndex+maxResult);
			int totle=   topDocs.totalHits;//查询结果的数量
			ScoreDoc[] scoreDoc = topDocs.scoreDocs;
			endIndex = Math.min(scoreDoc.length, maxResult+firstIndex);
			// 一、生成高亮器
			Formatter formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>"); // 指定高亮效果，默认为<b>与</b>
			Scorer scorer = new QueryScorer(query); // 指定查询条件
			Highlighter highlighter = new Highlighter(formatter, scorer);
			highlighter.setTextFragmenter(new SimpleFragmenter(30)); // 指定摘要的大小，默认是100个字符
			// ----------------------------------
	         	for(int i = firstIndex;i<endIndex;i++){
		 	Document  doc  =  indexSearcher.doc(scoreDoc[i].doc);
			String name  = highlighter.getBestFragment(configer.getAnalyzer(), "name",doc.get("name"));
 
		 	String sort = highlighter.getBestFragment(configer.getAnalyzer(), "sortName", doc.get("sortName"));
		 	String bargain = highlighter.getBestFragment(configer.getAnalyzer(), "bargain", doc.get("bargain"));
		 	String newGoods = highlighter.getBestFragment(configer.getAnalyzer(), "newGoods", doc.get("newGoods"));
			
			if(name!=null){
				doc.getField("name").setValue(name);
			}
		 
//			if(sort!=null){
//				 doc.getField("sort").setValue(sort);
//			}
			Goods good  = new GoodDocumentUtils().Document2Good(doc);
			goods.add(good);
				}
		} catch (Exception e) {
		  e.printStackTrace();
		} finally{
			try {
				indexSearcher.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 return new SearchResult(endIndex-firstIndex, goods);
	}

}
