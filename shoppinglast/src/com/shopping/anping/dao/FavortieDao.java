package com.shopping.anping.dao;

import java.util.List;

import com.shopping.guoguo.pojo.Favortie;

public interface FavortieDao {
     public List<Favortie>  findFavortiesByUid(int uid);
     public void add(Favortie favorite);
     public void deleteFavortiesById(int id);
     public Favortie findFavoritesByFavorites(Favortie favorite);
}
