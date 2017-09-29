package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main;

import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpView;

/**
 * Created by yudisetiawan on 9/28/17.
 */

interface MainView extends MvpView {

    void loadData();

    void loadDataFailed();
}
