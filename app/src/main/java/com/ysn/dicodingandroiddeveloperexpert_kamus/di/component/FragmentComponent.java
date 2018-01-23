/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.di.component;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.PerFragment;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.FragmentModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.englishindonesia.EnglishIndonesiaFragment;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.indonesiaenglish.IndonesiaEnglishFragment;

import dagger.Component;

/**
 * Created by yudisetiawan on 9/30/17.
 */

@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(EnglishIndonesiaFragment englishIndonesiaFragment);

    void inject(IndonesiaEnglishFragment indonesiaEnglishFragment);

}
