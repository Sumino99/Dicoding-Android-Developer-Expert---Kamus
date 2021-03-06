/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.di.module;

import android.app.Activity;
import android.content.Context;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yudisetiawan on 9/29/17.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /*@Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }*/

    @Provides
    Activity provideActivity() {
        return activity;
    }
}
