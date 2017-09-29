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
