package com.example.fikridzakwan.footballclubfragmentxmvp.UI.Detail;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fikridzakwan.footballclubfragmentxmvp.Model.ClubData;
import com.example.fikridzakwan.footballclubfragmentxmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailConstract.View {

    @BindView(R.id.img_logo_detail)
    ImageView imgLogoDetail;
    @BindView(R.id.txt_name_team_detail)
    TextView txtNameTeamDetail;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.card_view_detail)
    CardView cardViewDetail;
    @BindView(R.id.sv_detail)
    ScrollView svDetail;

    private ProgressDialog progressDialog;
    private ClubData clubData;
    private Menu menu;

    private DetailPresenter detailPresenter = new DetailPresenter(this);
    private Boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Detail Team");

        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDetailClub(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.favorite, menu);
        setFavorite();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_favorite:
                if (isFavorite) {
                    detailPresenter.revomeFavorite(this, clubData);
                } else {
                    detailPresenter.addFavorite(this, clubData);
                }
                isFavorite = detailPresenter.checkFavorite(this,clubData);
                setFavorite();
                break;
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }
        return true;
    }

    private void setFavorite() {
        if (isFavorite) {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black));
        } else  {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black));
        }
    }

    @Override
    public void showDetailClub(ClubData clubData) {
        this.clubData = clubData;
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        Glide.with(this).load(clubData.getClub_logo()).apply(options).into(imgLogoDetail);
        txtNameTeamDetail.setText(clubData.getNama_team());
        txtDesc.setText(clubData.getClub_description());
        // Mencek favorite ata tidak favorite
        isFavorite = detailPresenter.checkFavorite(this, clubData);
    }

    @Override
    public void showFailureMessage(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showSuccessMessage(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();

    }
}
