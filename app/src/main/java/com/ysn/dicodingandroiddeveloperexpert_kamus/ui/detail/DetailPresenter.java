package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.detail;

import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpPresenter;

import javax.inject.Inject;

/**
 * Created by yudisetiawan on 10/1/17.
 */

class DetailPresenter implements MvpPresenter<DetailView> {

    private final String TAG = getClass().getSimpleName();
    private DetailView detailView;

    @Inject
    public DetailPresenter() {
    }

    @Override
    public void onAttachView(DetailView mvpView) {
        detailView = mvpView;
    }

    @Override
    public void onDetachView() {
        detailView = null;
    }
}
