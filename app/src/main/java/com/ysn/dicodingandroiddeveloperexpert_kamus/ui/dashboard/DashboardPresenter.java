/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard;

import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpPresenter;

import javax.inject.Inject;

/**
 * Created by yudisetiawan on 9/29/17.
 */

public class DashboardPresenter implements MvpPresenter<DashboardView> {

    private final String TAG = getClass().getSimpleName();
    private DashboardView dashboardView;

    @Inject
    public DashboardPresenter() {
    }

    @Override
    public void onAttachView(DashboardView mvpView) {
        dashboardView = mvpView;
    }

    @Override
    public void onDetachView() {
        dashboardView = null;
    }
}
