package com.shopping.guoguo.dao;

import java.util.List;

import com.shopping.guoguo.pojo.Ad;

public interface AdDao {
public void addAd(Ad ad);
public void deleteAdByAid(int aid);
public List<Ad> showAllAds();
}
