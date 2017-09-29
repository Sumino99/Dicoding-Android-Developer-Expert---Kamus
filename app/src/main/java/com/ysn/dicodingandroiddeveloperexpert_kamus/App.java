package com.ysn.dicodingandroiddeveloperexpert_kamus;

import android.app.Application;
import android.content.Context;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.AppComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.DaggerAppComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.AppModule;

/**
 * Created by yudisetiawan on 9/27/17.
 */

public class App extends Application {

    protected AppComponent component;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);
    }

    /*@VisibleForTesting
    protected AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }*/

    public AppComponent getAppComponent() {
        return component;
    }

}
