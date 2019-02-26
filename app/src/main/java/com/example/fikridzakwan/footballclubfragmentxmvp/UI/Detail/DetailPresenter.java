package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.fikridzakwan.footballclubfragmentxmvp.Data.Local.FootballDB;
import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;
import com.example.fikridzakwan.footballclubfragmentxmvp.Utilts.Constants;

public class DetailPresenter implements DetailConstract.Presenter {

    private final DetailConstract.View view;
    private FootballDB footballDB;

    public DetailPresenter(DetailConstract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailClub(Bundle bundle) {
        if (bundle != null) {
            ClubData clubData = (ClubData) bundle.getSerializable(Constants.KEY_DATA);
            view.showDetailClub(clubData);
        }
    }

    @Override
    public void addFavorite(Context context, ClubData clubData) {
        footballDB = FootballDB.getFootballDB(context);
        footballDB.footballDao().insertItem(clubData);
        view.showSuccessMessage("Save");
    }

    @Override
    public void revomeFavorite(Context context, ClubData clubData) {
        footballDB = FootballDB.getFootballDB(context);
        footballDB.footballDao().delete(clubData);
        view.showSuccessMessage("Delete");
    }

    @Override
    public Boolean checkFavorite(Context context, ClubData clubData) {
        Boolean isFavorite = false;
        footballDB = FootballDB.getFootballDB(context);
        return isFavorite = footballDB.footballDao().selectedItem(clubData.getId_team()) != null;
    }
}
