package com.example.koncia.footballapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.koncia.footballapplication.FootballApp;
import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.dagger.AppModule;
import com.example.koncia.footballapplication.dagger.DataModule;
import com.example.koncia.footballapplication.dagger.MainModule;
import com.example.koncia.footballapplication.dagger.MenuModule;
import com.example.koncia.footballapplication.intefaces.MainContract;
import com.example.koncia.footballapplication.presenters.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.main_image_view)
    ImageView imageView;

    @BindView(R.id.main_progress_bar)
    ProgressBar progressBar;

    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onStop() {
        presenter.dispose();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((FootballApp) getApplication())
                .getAppComponent()
                .plus(new MainModule(this))
                .inject(this);

        progressBar.setMax(5);

        Glide.with(this).load(presenter.getUrlForStartingScreen(this)).into(imageView);
        presenter.getLeagues();
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
