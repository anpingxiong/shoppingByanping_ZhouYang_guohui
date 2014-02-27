package com.shopping.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sun.rmi.server.LoaderHandler;

public class PropUtil {
   public static String getValue(String key,String propFileName){
	   String value =null;
	   Properties prop = new Properties();
	   InputStream is = PropUtil.class.getClassLoader().getResourceAsStream(propFileName);
	   try {
		prop.load(is);
		value = prop.getProperty(key);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   return value;
   }
}
 