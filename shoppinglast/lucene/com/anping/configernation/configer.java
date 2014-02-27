package com.anping.configernation;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class configer {
	private static  Directory  directory;
    private static  Analyzer  analyzer;
    static {
    	try {
			directory  = FSDirectory.open(new File("./Resource/"));
			analyzer   = new IKAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public static Directory getDirectory() {
		return directory;
	}
	
	public static Analyzer getAnalyzer() {
		return analyzer;
	}
}
