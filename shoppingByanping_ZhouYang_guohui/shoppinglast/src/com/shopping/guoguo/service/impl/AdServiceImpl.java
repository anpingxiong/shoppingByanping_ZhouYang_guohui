package com.shopping.guoguo.service.impl;

import java.util.List;

import com.shopping.factory.CreateDaoFactory;
import com.shopping.guoguo.dao.AdDao;
import com.shopping.guoguo.pojo.Ad;
import com.shopping.guoguo.service.AdService;

public class AdServiceImpl implements AdService {
private AdServiceImpl(){}
private static AdDao adDao = (AdDao) CreateDaoFactory.createDao("com.shopping.guoguo.dao.impl.AdDao");
private static AdService adService  = new AdServiceImpl();
public static AdService getInstance(){
	return adService;
}
	public void insertAd(Ad ad) {
		adDao.addAd(ad);

	}

	public void removeAd(int aid) {
		adDao.deleteAdByAid(aid);

	}
	public List<Ad> getAllAds() {
		return adDao.showAllAds();
	
	}

}
