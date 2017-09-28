package com.ysn.dicodingandroiddeveloperexpert_kamus;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ApplicationContext;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yudisetiawan on 9/27/17.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "kamuskus.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 1;
    }

    @Provides
    SharedPreferences provideSharedPrefSettings() {
        return application.getSharedPreferences("settings-prefs", Context.MODE_PRIVATE);
    }

}
