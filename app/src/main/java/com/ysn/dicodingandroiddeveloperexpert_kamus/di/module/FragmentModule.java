/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yudisetiawan on 9/30/17.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    /*@Provides
    @ActivityContext
    Context provideContext() {
        return fragment.getContext();
    }*/

    @Provides
    Fragment provideFragment() {
        return fragment;
    }
}
