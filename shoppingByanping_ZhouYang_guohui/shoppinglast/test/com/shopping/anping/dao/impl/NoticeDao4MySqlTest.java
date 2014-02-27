package com.shopping.anping.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.shopping.guoguo.pojo.Notice;

public class NoticeDao4MySqlTest extends NoticeDao4MySqlImpl {

	@Test
	public void test() {
		Notice notice  = new Notice ();
		notice.setTitle("呵呵");
		notice.setContent("嘻嘻嘻");
		notice.setPdate(new Date());
		notice.setOverdate(new Date());
		 new NoticeDao4MySqlImpl().add(notice);
	}

}
