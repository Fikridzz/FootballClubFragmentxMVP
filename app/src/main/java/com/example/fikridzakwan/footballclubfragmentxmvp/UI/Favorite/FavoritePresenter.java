package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Favorite;

import android.content.Context;

import com.example.fikridzakwan.footballclubfragmentxmvp.Data.Local.FootballDB;
import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;

import java.util.List;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View view;
    private FootballDB footballDB;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListClub(Context context) {
        footballDB = FootballDB.getFootballDB(context);

        if (footballDB.footballDao().selectFavorite() != null) {
            List<ClubData> list = footballDB.footballDao().selectFavorite();
            view.showDataList(list);
            // Ada 2 cara yg atas dan bawah
//            view.showDataList(footballDB.footballDao().selectFavorite());
        } else {
            view.showFailurMessage("There is no favorite in here");
        }
        view.hideRefresh();
    }
}
