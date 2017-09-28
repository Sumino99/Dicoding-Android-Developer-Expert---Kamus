package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ysn.dicodingandroiddeveloperexpert_kamus.App;
import com.ysn.dicodingandroiddeveloperexpert_kamus.R;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.ActivityComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.DaggerActivityComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    private final String TAG = getClass().getSimpleName();
    @Inject
    MainPresenter mainPresenter;
    @Inject
    DataManager dataManager;
    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
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
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        onAttach();
        // TODO: 9/28/17 do something in here
    }

    @Override
    protected void onResume() {
        onAttach();
        super.onResume();
    }

    @Override
    protected void onPause() {
        onDetach();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        onDetach();
        super.onDestroy();
    }

    @Override
    public void onAttach() {
        mainPresenter.onAttachView(this);
    }

    @Override
    public void onDetach() {
        mainPresenter.onDetachView();
    }
}

