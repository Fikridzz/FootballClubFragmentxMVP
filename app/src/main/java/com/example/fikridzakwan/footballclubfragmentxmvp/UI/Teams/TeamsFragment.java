package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Teams;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;
import com.example.fikridzakwan.footballclubfragmentxmvp.R;
import com.example.fikridzakwan.footballclubfragmentxmvp.UI.Teams.Adapter.TeamsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends Fragment implements TeamsContract.View {

    @BindView(R.id.rvClub)
    RecyclerView rvClub;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;

    private ProgressDialog progressDialog;
    private TeamsPresenter teamsPresenter = new TeamsPresenter(this);


    public TeamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        unbinder = ButterKnife.bind(this, view);

        teamsPresenter.getDataListClub();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                teamsPresenter.getDataListClub();
            }
        });

        return view;
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Get Data");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
        swipeRefresh.setRefreshing(false);

    }

    @Override
    public void showFailurMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showDataListClub(List<ClubData> clubDataList) {
        rvClub.setLayoutManager(new LinearLayoutManager(getContext()));
        rvClub.setAdapter(new TeamsAdapter(getContext(), clubDataList));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
