/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.data.sharedprefs;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by yudisetiawan on 9/29/17.
 */

@Singleton
public class SharedPrefsSettings {

    public static final String PREF_KEY_FIRST_INSTALL = "first_install";
    private SharedPreferences sharedPreferences;

    @Inject
    public SharedPrefsSettings(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void put(String key, String value) {
        sharedPreferences.edit()
                .putString(key, value)
                .apply();
    }

    public void put(String key, int value) {
        sharedPreferences.edit()
                .putInt(key, value)
                .apply();
    }

    public void put(String key, float value) {
        sharedPreferences.edit()
                .putFloat(key, value)
                .apply();
    }

    public void put(String key, boolean value) {
        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    public String get(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key) {
        sharedPreferences.edit()
                .remove(key)
                .apply();
    }

}
