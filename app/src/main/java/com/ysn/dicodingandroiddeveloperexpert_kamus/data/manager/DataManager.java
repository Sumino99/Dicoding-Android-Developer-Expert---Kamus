/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager;

import android.content.Context;

import com.ysn.dicodingandroiddeveloperexpert_kamus.data.db.DatabaseHelper;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.sharedprefs.SharedPrefsSettings;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ApplicationContext;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by yudisetiawan on 9/29/17.
 */

@Singleton
public class DataManager {

    private Context context;
    private DatabaseHelper databaseHelper;
    private SharedPrefsSettings sharedPrefsSettings;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DatabaseHelper databaseHelper,
                       SharedPrefsSettings sharedPrefsSettings) {
        this.context = context;
        this.databaseHelper = databaseHelper;
        this.sharedPrefsSettings = sharedPrefsSettings;
    }

    public void saveFirstInstallConfig(String firstInstallStatus) {
        sharedPrefsSettings.put(
                SharedPrefsSettings.PREF_KEY_FIRST_INSTALL,
                firstInstallStatus
        );
    }

    public String getFirstInstallConfig() {
        return sharedPrefsSettings.get(
                SharedPrefsSettings.PREF_KEY_FIRST_INSTALL,
                null
        );
    }

    public Long insertDataKamusIndonesiaToEnglish(KataKamus kataKamus) throws Exception {
        return databaseHelper.insertDataKamusIndonesiaToEnglish(kataKamus);
    }

    public Long insertDataKamusEnglishToIndonesia(KataKamus kataKamus) throws Exception {
        return databaseHelper.insertDataKamusEnglishToIndonesia(kataKamus);
    }

    public int insertDataKamusEnglishToIndonesia(List<KataKamus> listKataKamusEnglishIndonesia) throws Exception {
        return databaseHelper.insertListDataKamusEnglishToIndonesia(listKataKamusEnglishIndonesia);
    }

    public int deleteDataKamusIndonesiaToEnglish() throws Exception {
        return databaseHelper.deleteDataKamusIndonesiaToEnglish();
    }

    public int deleteDataKamusEnglishToIndonesia() throws Exception {
        return databaseHelper.deleteDataKamusEnglishToIndonesia();
    }

    public int getSizeItemDataKamusEnglishToIndonesia() {
        return databaseHelper.itemCountDataKamusEnglishToIndonesia();
    }

    public int getSizeItemDataKamusIndonesiaToEnglish() {
        return databaseHelper.itemCountDataKamusIndonesiaToEnglish();
    }

    public List<KataKamus> searchKeywordEnglishIndonesia(String keyword) {
        return databaseHelper.getDataEnglishIndonesiaByKeyword(keyword);
    }

    public List<KataKamus> searchKeywordIndonesiaEnglish(String keyword) {
        return databaseHelper.getDataIndonesiaEnglishByKeyword(keyword);
    }

    public int insertDatakamusIndonesiaToEnglish(List<KataKamus> listKataKamusIndonesiaEnglish) {
        return databaseHelper.insertListDataKamusIndonesiaToEnglish(listKataKamusIndonesiaEnglish);
    }
}
