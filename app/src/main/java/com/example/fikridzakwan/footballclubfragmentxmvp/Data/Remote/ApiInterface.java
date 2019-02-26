package com.example.fikridzakwan.footballclubfragmentxmvp.Data.Remote;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v1/json/1/search_all_teams.php")
    Call<ClubResponse> getClub (@Query("s") String Soccer, @Query("c") String England);

    @GET("api/v1/json/1/lookupteam.php")
    Call<ClubResponse> getDetailClub (@Query("id") int idDetail);
}
