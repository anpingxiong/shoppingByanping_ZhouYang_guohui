package com.shopping.anping.service.impl;

import java.util.List;

import sun.font.CreatedFontTracker;

import com.shopping.anping.dao.FavortieDao;
import com.shopping.anping.service.FavoriteService;
import com.shopping.factory.CreateDaoFactory;
import com.shopping.guoguo.pojo.Favortie;

public class FavoriteServiceImpl  implements FavoriteService{
  private FavoriteServiceImpl(){}
  private  static FavoriteServiceImpl  service = new FavoriteServiceImpl();
  private static   FavortieDao    favortieDao  = (FavortieDao)CreateDaoFactory.createDao("com.shopping.anping.dao.impl.FavoriteDao");  
  public   static FavoriteServiceImpl  getInstatnce(){
	  return    service;
  }   
  public void addFavorite(Favortie favorite) {
	  favortieDao.add(favorite);
	}

	public void deleteFavoriteById(int id) {
		favortieDao.deleteFavortiesById(id);
	}

	public List<Favortie> showAllFavorite(int uid ) {
	 	return favortieDao.findFavortiesByUid(uid);
	}
	public Favortie checkFavoriteIsIn(Favortie favorite) {
		 return favortieDao.findFavoritesByFavorites(favorite);
	}

}
