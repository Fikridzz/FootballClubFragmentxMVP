package com.example.fikridzakwan.footballclubfragmentxmvp.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.fikridzakwan.footballclubfragmentxmvp.R;
import com.example.fikridzakwan.footballclubfragmentxmvp.UI.Favorite.FavoriteFragment;
import com.example.fikridzakwan.footballclubfragmentxmvp.UI.Teams.TeamsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_teams:
                    getSupportActionBar().setTitle("Teams");
                    setTitle("Teams");
                    // Menampilkan Teams Fragment
                    TeamsFragment teamsFragment = new TeamsFragment();
                    loadFragment(teamsFragment);
                    return true;
                case R.id.navigation_favorite:
                    getSupportActionBar().setTitle("Favorite Teams");
                    // Menampilkan Favorite Fragment
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    loadFragment(favoriteFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Menampilkan Title
        getSupportActionBar().setTitle("Teams");

        // Buat object fragment teams
        TeamsFragment teamsFragment = new TeamsFragment();
        loadFragment(teamsFragment);
    }

    private void loadFragment(Fragment fragment) {
        // Menampilkan fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
