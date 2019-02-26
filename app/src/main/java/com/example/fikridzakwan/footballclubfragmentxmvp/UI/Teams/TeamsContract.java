package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Teams;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;

import java.util.List;

public interface TeamsContract {
    interface View {
        void showProgress();
        void hideProgress();
        void showFailurMessage(String msg);
        void showDataListClub(List<ClubData> clubDataList);
    }
    interface Presenter {
        void getDataListClub();
    }
}
