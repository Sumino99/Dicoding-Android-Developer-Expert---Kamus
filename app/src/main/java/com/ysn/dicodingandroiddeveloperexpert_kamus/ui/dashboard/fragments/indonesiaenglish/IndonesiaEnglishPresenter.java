/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.indonesiaenglish;

import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by yudisetiawan on 9/29/17.
 */

class IndonesiaEnglishPresenter implements MvpPresenter<IndonesiaEnglishView> {

    private final String TAG = getClass().getSimpleName();
    private IndonesiaEnglishView indonesiaEnglishView;

    @Inject
    public IndonesiaEnglishPresenter() {
    }

    @Override
    public void onAttachView(IndonesiaEnglishView mvpView) {
        indonesiaEnglishView = mvpView;
    }

    @Override
    public void onDetachView() {
        indonesiaEnglishView = null;
    }

    List<KataKamus> onSearchingKeyword(DataManager dataManager, String keyword) {
        List<KataKamus> listDataKeyword = new ArrayList<>();
        if (keyword.isEmpty() || keyword.equals("")) {
            return listDataKeyword;
        }
        listDataKeyword = dataManager.searchKeywordIndonesiaEnglish(keyword);
        return listDataKeyword;
    }
}
