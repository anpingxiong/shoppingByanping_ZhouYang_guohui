package com.shopping.util;

import org.apache.log4j.Logger;

public class GetLogger {
   public  static  Logger getLogger(){
	   Logger  logger = Logger.getLogger(GetLogger.class);
	   return logger;
   }
}
