package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Teams.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;
import com.example.fikridzakwan.footballclubfragmentxmvp.R;
import com.example.fikridzakwan.footballclubfragmentxmvp.UI.Detail.DetailActivity;
import com.example.fikridzakwan.footballclubfragmentxmvp.Utilts.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private Context context;
    private List<ClubData> clubDataList;

    public TeamsAdapter(Context context, List<ClubData> clubDataList) {
        this.context = context;
        this.clubDataList = clubDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_club, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ClubData clubData = clubDataList.get(i);

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        viewHolder.txtNamaClub.setText(clubData.getNama_team());
        Glide.with(context).load(clubData.getClub_logo()).apply(options).into(viewHolder.imgLogoClub);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,DetailActivity.class).putExtra(Constants.KEY_DATA,clubData));
            }
        });

    }

    @Override
    public int getItemCount() {
        return clubDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgLogoClub)
        ImageView imgLogoClub;
        @BindView(R.id.txtNamaClub)
        TextView txtNamaClub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
