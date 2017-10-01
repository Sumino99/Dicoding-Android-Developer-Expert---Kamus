package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.englishindonesia;

import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by yudisetiawan on 9/29/17.
 */

public class EnglishIndonesiaPresenter implements MvpPresenter<EnglishIndonesiaView> {

    private final String TAG = getClass().getSimpleName();
    private EnglishIndonesiaView englishIndonesiaView;

    @Inject
    public EnglishIndonesiaPresenter() {
    }

    @Override
    public void onAttachView(EnglishIndonesiaView mvpView) {
        englishIndonesiaView = mvpView;
    }

    @Override
    public void onDetachView() {
        englishIndonesiaView = null;
    }

    List<KataKamus> onSearchingKeyword(DataManager dataManager, String keyword) {
        List<KataKamus> listDataKeyword = new ArrayList<>();
        if (keyword.isEmpty() || keyword.equals("")) {
            return listDataKeyword;
        }
        listDataKeyword = dataManager.searchKeywordEnglishIndonesia(keyword);
        return listDataKeyword;
    }
}
