package com.example.fikridzakwan.footballclubfragmentxmvp.Data.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;

import java.util.List;

@Dao
public interface FootballDao {

    @Insert
    void insertItem(ClubData clubData);

    @Query("SELECT * FROM teams WHERE idTeams = :id")
    ClubData selectedItem(String id);

    @Delete
    void delete(ClubData clubData);

    @Query("SELECT * FROM teams ORDER BY nama_team ASC")
    List<ClubData> selectFavorite();

}
