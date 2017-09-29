package com.ysn.dicodingandroiddeveloperexpert_kamus.di.component;

import android.app.Application;
import android.content.Context;

import com.ysn.dicodingandroiddeveloperexpert_kamus.App;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.AppModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.db.DatabaseHelper;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.sharedprefs.SharedPrefsSettings;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yudisetiawan on 9/27/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DatabaseHelper getDatabaseHelper();

    SharedPrefsSettings getSharedPrefsSettings();

    DataManager getDataManager();

}
