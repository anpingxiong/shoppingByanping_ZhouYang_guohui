package com.shopping.factory;

import com.shopping.util.PropUtil;

 

public class CreateDaoFactory {
    public static Object createDao(String DaoName){
    	Object object=null;
    	String  dbName=PropUtil.getValue("dbname","DBConfig.properties");
    	DaoName= DaoName+"4"+dbName+"Impl";
    	System.out.println(DaoName);
    	try {
    		object=	Class.forName(DaoName).newInstance();
		} catch (InstantiationException e) {
		 e.printStackTrace();
		} catch (IllegalAccessException e) {
		 e.printStackTrace();
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}
    	
    	return object;
    }
}
