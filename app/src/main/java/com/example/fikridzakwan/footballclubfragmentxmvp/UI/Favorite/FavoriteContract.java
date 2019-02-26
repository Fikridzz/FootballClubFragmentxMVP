package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Favorite;

import android.content.Context;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;

import java.util.List;

public interface FavoriteContract {
    interface View {
        void showDataList(List<ClubData> clubDataList);
        void showFailurMessage(String msg);
        void hideRefresh();
    }
    interface Presenter {
        void getDataListClub(Context context);
    }
}
