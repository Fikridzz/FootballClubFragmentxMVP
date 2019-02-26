package com.example.fikridzakwan.footballclubfragmentxmvp.Data.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;
import com.example.fikridzakwan.footballclubfragmentxmvp.Utilts.Constants;

@Database(entities = ClubData.class, version = 1)
public abstract class FootballDB extends RoomDatabase {

    public abstract FootballDao footballDao();

    private static FootballDB footballDB;

    public static FootballDB getFootballDB(Context context) {
        synchronized (FootballDB.class) {
            if (footballDB == null) {
                footballDB = Room.databaseBuilder(context, FootballDB.class, "db_football").allowMainThreadQueries().build();
            } return footballDB;
        }
    }
}
