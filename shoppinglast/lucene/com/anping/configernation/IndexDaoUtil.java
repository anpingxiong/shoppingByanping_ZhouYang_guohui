package com.anping.configernation;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;



public class IndexDaoUtil {
	  private static IndexWriter  index;
	    static{
	    	try {
				index  = new IndexWriter(configer.getDirectory(), configer.getAnalyzer(),MaxFieldLength.LIMITED );
			System.out.println("Index启动");
	    	} catch (Exception e) {
				e.printStackTrace();
			} 
	       Runtime.getRuntime().addShutdownHook(new Thread(){

			public void run() {
				try {
					index.close();
					System.out.println("Index关闭");
				} catch (Exception e) {
					e.printStackTrace();
				} 
				super.run();
			}
	    	   
	       });
	    }
		
		public static IndexWriter getIndex() {
			return index;
		}
}
