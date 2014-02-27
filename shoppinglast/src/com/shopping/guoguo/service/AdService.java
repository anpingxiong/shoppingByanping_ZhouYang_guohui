package com.shopping.guoguo.service;

import java.util.List;

import com.shopping.guoguo.pojo.Ad;

public interface AdService {
public void insertAd(Ad ad);
public void removeAd(int aid);
public List<Ad> getAllAds();
}
