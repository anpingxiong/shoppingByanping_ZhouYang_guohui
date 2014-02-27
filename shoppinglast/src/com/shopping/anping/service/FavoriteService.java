package com.shopping.anping.service;

import java.util.List;

import com.shopping.guoguo.pojo.Favortie;

public interface FavoriteService {
       public void   addFavorite(Favortie favorite);
       public void deleteFavoriteById(int id );
       public List<Favortie> showAllFavorite(int uid );
       public  Favortie  checkFavoriteIsIn(Favortie favorite);
}
