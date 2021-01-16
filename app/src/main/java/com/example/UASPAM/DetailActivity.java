package com.example.UASPAM;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sport.R;

public class DetailActivity extends AppCompatActivity {

    private String title;
    private String home;
    private String homescore;
    private String away;
    private String awayscore;
    private String date;
    private String img;
    DataHandler da;

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setTitle(String tome) {
        this.title = title;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setHomescore(String homescore) {
        this.homescore = homescore;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public void setAwayscore(String awayscore) {
        this.awayscore = awayscore;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle1() {
        return title;
    }

    public String getHome() {
        return home;
    }

    public String getHomescore() {
        return homescore;
    }

    public String getAway() {
        return away;
    }

    public String getAwayscore() {
        return awayscore;
    }

    public String getDate() {
        return date;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView title = (TextView) findViewById(R.id.tv_title_detail);
        TextView Home = (TextView) findViewById(R.id.txtHome_detail);
        TextView HomeScore = (TextView) findViewById(R.id.txtHomeScore_detail);
        TextView Away = (TextView) findViewById(R.id.txtAway_detail);
        TextView AwayScore = (TextView) findViewById(R.id.txtAwayScore_detail);
        TextView Date = (TextView) findViewById(R.id.txtDate);
        ImageView image = (ImageView) findViewById(R.id.img_detail);
        String coverImageSrc = getIntent().getStringExtra("src");
        ImageView imageView = (ImageView) findViewById(R.id.img_detail);

        Glide.with(this)
                .load(getIntent().getStringExtra("img"))
                .into(imageView);

        title.setText(getIntent().getStringExtra("title"));
        Home.setText(getIntent().getStringExtra("Home"));
        HomeScore.setText(getIntent().getStringExtra("HomeScore"));
        Away.setText(getIntent().getStringExtra("Away"));
        AwayScore.setText(getIntent().getStringExtra("AwayScore"));
        Date.setText(getIntent().getStringExtra("Date"));

        Button btnfav = findViewById(R.id.btn_Fav);

        setTitle(getIntent().getStringExtra("title"));
        setHome(getIntent().getStringExtra("Home"));
        setHomescore(getIntent().getStringExtra("HomeScore"));
        setAway(getIntent().getStringExtra("Away"));
        setAwayscore(getIntent().getStringExtra("AwayScore"));
        setDate(getIntent().getStringExtra("Date"));


        btnfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = da.getWritableDatabase();
                db.execSQL("insert into favorite(title,home,homescore,away,awayscore,date,img) values " +
                        "('"+getTitle1()+"',)" +
                        "('"+getHome()+"',)" +
                        "('"+getHomescore()+"',)" +
                        "('"+getAway()+"',)" +
                        "('"+getAwayscore()+"',)" +
                        "('"+getDate()+"',)" +
                        "('"+getImg()+"')");


            }
        });
    }
}