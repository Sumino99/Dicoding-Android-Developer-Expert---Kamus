package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.base;

/**
 * Created by yudisetiawan on 9/28/17.
 */

public interface MvpPresenter<T extends MvpView> {

    void onAttachView(T mvpView);

    void onDetachView();

}
