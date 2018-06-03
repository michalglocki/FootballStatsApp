package com.example.koncia.footballapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.intefaces.MainActivityContract;
import com.example.koncia.footballapplication.presenters.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.main_image_view)
    ImageView imageView;

    @BindView(R.id.main_progress_bar)
    ProgressBar progressBar;

    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        progressBar.setMax(1);
        presenter = new MainPresenter(this);

        Glide.with(this).load(presenter.getUrlForStartingScreen(this)).into(imageView);

        try {
            presenter.updateProgresValue(progressBar.getMax());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upgradeProgresBar(int progress) {
        progressBar.setProgress(progress);
    }

    @Override
    public void goToTheMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
