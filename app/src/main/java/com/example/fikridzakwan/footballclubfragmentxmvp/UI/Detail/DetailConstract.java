package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;

public interface DetailConstract {
    interface View {
        void showDetailClub(ClubData clubData);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }
    interface Presenter {
        void getDetailClub(Bundle bundle);
        void addFavorite(Context context, ClubData clubData);
        void revomeFavorite(Context context, ClubData clubData);
        Boolean checkFavorite(Context context, ClubData clubData);
    }
}
