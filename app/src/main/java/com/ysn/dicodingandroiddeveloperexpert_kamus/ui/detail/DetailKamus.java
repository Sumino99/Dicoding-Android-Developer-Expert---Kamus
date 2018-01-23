/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ysn.dicodingandroiddeveloperexpert_kamus.App;
import com.ysn.dicodingandroiddeveloperexpert_kamus.R;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.db.DatabaseHelper;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.ActivityComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.DaggerActivityComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.ActivityModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailKamus extends AppCompatActivity implements DetailView {

    private final String TAG = getClass().getSimpleName();
    @Inject
    DataManager dataManager;
    @Inject
    DetailPresenter detailPresenter;
    private ActivityComponent activityComponent;

    @BindView(R.id.text_view_from_word_activity_detail_kamus)
    TextView textViewFromWordActivityDetailKamus;
    @BindView(R.id.text_view_to_word_activity_detail_kamus)
    TextView textViewToWordActivityDetailKamus;

    private ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent
                    .builder()
                    .activityModule(new ActivityModule(this))
                    .appComponent(App.get(this).getAppComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kamus);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        onAttachMvpView();
        doLoadData();
    }

    @Override
    public void onAttachMvpView() {
        detailPresenter.onAttachView(this);
    }

    @Override
    public void onDetachMvpView() {
        detailPresenter.onDetachView();
    }

    @Override
    protected void onResume() {
        onAttachMvpView();
        super.onResume();
    }

    @Override
    protected void onPause() {
        onDetachMvpView();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        onDetachMvpView();
        super.onDestroy();
    }

    private void doLoadData() {
        Bundle bundle = getIntent().getExtras();
        KataKamus kataKamusDetail = bundle.getParcelable("kataKamus");
        textViewFromWordActivityDetailKamus.setText(kataKamusDetail.getFromWord());
        textViewToWordActivityDetailKamus.setText(kataKamusDetail.getToWord());
    }
}
