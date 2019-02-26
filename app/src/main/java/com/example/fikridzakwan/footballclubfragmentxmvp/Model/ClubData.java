package com.example.fikridzakwan.footballclubfragmentxmvp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "teams")
public class ClubData implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idTeams")
    @SerializedName("idTeam")
    @NonNull private String id_team;

    @ColumnInfo(name = "nama_team")
    @SerializedName("strTeam")
    private String nama_team;

    @ColumnInfo(name = "stadium_team")
    @SerializedName("strStadium")
    private String stadium_team;

    @ColumnInfo(name = "foto_stadium")
    @SerializedName("strStadiumThumb")
    private String foto_stadium;

    @ColumnInfo(name = "stadium_description")
    @SerializedName("strStadiumDescription")
    private String stadium_description;

    @ColumnInfo(name = "stadium_location")
    @SerializedName("strStadiumLocation")
    private String stadium_location;

    @ColumnInfo(name = "club_description")
    @SerializedName("strDescriptionEN")
    private String club_description;

    @ColumnInfo(name = "club_logo")
    @SerializedName("strTeamBadge")
    private String club_logo;

    public ClubData(String id_team, String nama_team, String stadium_team, String foto_stadium, String stadium_description, String stadium_location, String club_description, String club_logo) {
        this.id_team = id_team;
        this.nama_team = nama_team;
        this.stadium_team = stadium_team;
        this.foto_stadium = foto_stadium;
        this.stadium_description = stadium_description;
        this.stadium_location = stadium_location;
        this.club_description = club_description;
        this.club_logo = club_logo;
    }

    public String getId_team() {
        return id_team;
    }

    public String getNama_team() {
        return nama_team;
    }

    public String getStadium_team() {
        return stadium_team;
    }

    public String getFoto_stadium() {
        return foto_stadium;
    }

    public String getStadium_description() {
        return stadium_description;
    }

    public String getStadium_location() {
        return stadium_location;
    }

    public String getClub_description() {
        return club_description;
    }

    public String getClub_logo() {
        return club_logo;
    }
}
