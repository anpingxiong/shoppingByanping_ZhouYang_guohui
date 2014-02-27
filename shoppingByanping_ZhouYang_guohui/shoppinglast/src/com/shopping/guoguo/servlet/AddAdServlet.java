package com.shopping.guoguo.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shopping.guoguo.pojo.Ad;
import com.shopping.guoguo.service.impl.AdServiceImpl;
import com.shopping.util.StringToDate;

public class AddAdServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload upload = new SmartUpload();
		upload.initialize(this.getServletConfig(), request, response);
		upload.setCharSet("UTF-8");
		try {
			upload.upload();
		
		Request req = upload.getRequest();
		
		String exp = req.getParameter("exp");
		String aURL = req.getParameter("aURL");
		String overdate = req.getParameter("overdate");
		System.out.println(overdate+"000000000 ");
		try {
	
		Ad ad = new Ad();
		ad.setaURL(aURL);
		ad.setExp(exp);
		ad.setOverdate(StringToDate.parseStringToDate(overdate));// 怎么回事?我的date在pojo和方法中都是导入的sql这里是util包？
		Files files = upload.getFiles();
		File file = files.getFile(0);
		file.saveAs(".//images//goods//"+exp+".jpg");
		AdServiceImpl.getInstance().insertAd(ad);
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("添加广告成功!");
	
		
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		response.sendRedirect("./manage/ad.jsp");
	}

}
}
