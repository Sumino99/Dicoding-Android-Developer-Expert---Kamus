/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.di.component;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.PerActivity;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.ActivityModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.DashboardActivity;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.detail.DetailKamus;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by yudisetiawan on 9/29/17.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(DashboardActivity dashboardActivity);

    void inject(DetailKamus detailKamus);

}
