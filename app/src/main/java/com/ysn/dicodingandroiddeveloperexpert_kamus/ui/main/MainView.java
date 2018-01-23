/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main;

import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpView;

/**
 * Created by yudisetiawan on 9/28/17.
 */

interface MainView extends MvpView {

    void loadData();

    void loadDataFailed();
}
