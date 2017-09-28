package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main;

import android.util.Log;

import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpPresenter;

import javax.inject.Inject;

/**
 * Created by yudisetiawan on 9/28/17.
 */

public class MainPresenter implements MvpPresenter<MainView> {

    private final String TAG = getClass().getSimpleName();
    private MainView mainView;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void onAttachView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onDetachView() {
        mainView = null;
    }

}
