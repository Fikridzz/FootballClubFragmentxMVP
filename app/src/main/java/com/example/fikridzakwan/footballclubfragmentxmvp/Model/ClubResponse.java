package com.example.fikridzakwan.footballclubfragmentxmvp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClubResponse {

    @SerializedName("teams")
    private List<ClubData> teams;

    public List<ClubData> getTeams() {
        return teams;
    }
}
