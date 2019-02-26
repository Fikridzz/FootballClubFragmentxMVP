package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Teams;

import android.widget.Toast;

import com.example.fikridzakwan.footballclubfragmentxmvp.Data.Remote.ApiClient;
import com.example.fikridzakwan.footballclubfragmentxmvp.Data.Remote.ApiInterface;
import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubResponse;
import com.example.fikridzakwan.footballclubfragmentxmvp.Utilts.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsPresenter implements TeamsContract.Presenter {

    private final TeamsContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public TeamsPresenter(TeamsContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListClub() {
        view.showProgress();

        Call<ClubResponse> call = apiInterface.getClub(Constants.s, Constants.c);
        call.enqueue(new Callback<ClubResponse>() {
            @Override
            public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                view.hideProgress();

                if (response.body() != null) {
                    view.showDataListClub(response.body().getTeams());
                } else {
                    view.showFailurMessage("Data Kosong");
                }
            }

            @Override
            public void onFailure(Call<ClubResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailurMessage(t.getMessage());

            }
        });
    }
}
