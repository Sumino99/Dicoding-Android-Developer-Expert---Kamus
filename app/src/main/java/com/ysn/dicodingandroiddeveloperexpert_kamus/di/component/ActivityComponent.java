package com.ysn.dicodingandroiddeveloperexpert_kamus.di.component;

import com.ysn.dicodingandroiddeveloperexpert_kamus.AppComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.PerActivity;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.ActivityModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by yudisetiawan on 9/29/17.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
