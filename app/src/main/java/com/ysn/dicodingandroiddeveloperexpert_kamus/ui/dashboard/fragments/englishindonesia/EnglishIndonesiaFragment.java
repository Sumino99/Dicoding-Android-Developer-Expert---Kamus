/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.englishindonesia;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.App;
import com.ysn.dicodingandroiddeveloperexpert_kamus.R;
import com.ysn.dicodingandroiddeveloperexpert_kamus.data.manager.DataManager;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.DaggerFragmentComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.component.FragmentComponent;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.module.FragmentModule;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.adapter.AdapterSearchingKeyword;
import com.ysn.dicodingandroiddeveloperexpert_kamus.ui.detail.DetailKamus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishIndonesiaFragment extends Fragment implements EnglishIndonesiaView {

    private final String TAG = getClass().getSimpleName();
    @Inject
    EnglishIndonesiaPresenter englishIndonesiaPresenter;
    @Inject
    DataManager dataManager;
    private FragmentComponent fragmentComponent;
    private List<KataKamus> listDataKataKamusEnglishIndonesia;
    private AdapterSearchingKeyword adapterSearchingKeyword;

    @BindView(R.id.edit_text_keyword_english_fragment_english_indonesia)
    EditText editTextKeywordEnglishFragmentEnglishIndonesia;
    @BindView(R.id.recycler_view_result_data_keyword_fragment_english_indonesia)
    RecyclerView recyclerViewResultDataKeywordFragmentEnglishIndonesia;
    private String inputKeyword;

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = DaggerFragmentComponent
                    .builder()
                    .fragmentModule(new FragmentModule(this))
                    .appComponent(App.get(getContext()).getAppComponent())
                    .build();
        }
        return fragmentComponent;
    }

    public EnglishIndonesiaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_english_indonesia, container, false);
        ButterKnife.bind(this, view);
        getFragmentComponent().inject(this);
        onAttachMvpView();
        initData();
        initListeners();

        return view;
    }

    @Override
    public void onResume() {
        onAttachMvpView();
        super.onResume();
    }

    @Override
    public void onPause() {
        onDetachMvpView();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        onDetachMvpView();
        super.onDestroy();
    }

    @Override
    public void onAttachMvpView() {
        englishIndonesiaPresenter.onAttachView(this);
    }

    @Override
    public void onDetachMvpView() {
        englishIndonesiaPresenter.onDetachView();
    }

    private void initData() {
        listDataKataKamusEnglishIndonesia = new ArrayList<>();
        adapterSearchingKeyword = new AdapterSearchingKeyword(
                listDataKataKamusEnglishIndonesia,
                new AdapterSearchingKeyword.ListenerAdapterSearchingKeyword() {
                    @Override
                    public void onClickItemKeyword(KataKamus katakamusSelected) {
                        Intent intentDetailKamus = new Intent(
                                getContext(),
                                DetailKamus.class
                        );
                        intentDetailKamus.putExtra("kataKamus", katakamusSelected);
                        startActivity(intentDetailKamus);
                    }
                }
        );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewResultDataKeywordFragmentEnglishIndonesia.setLayoutManager(linearLayoutManager);
        recyclerViewResultDataKeywordFragmentEnglishIndonesia.setAdapter(adapterSearchingKeyword);
    }

    private void initListeners() {
        RxTextView.afterTextChangeEvents(editTextKeywordEnglishFragmentEnglishIndonesia)
                .map(new Function<TextViewAfterTextChangeEvent, String>() {
                    @Override
                    public String apply(@NonNull TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) throws Exception {
                        return textViewAfterTextChangeEvent.editable().toString();
                    }
                })
                .map(new Function<String, List<KataKamus>>() {
                    @Override
                    public List<KataKamus> apply(@NonNull String keyword) throws Exception {
                        return englishIndonesiaPresenter.onSearchingKeyword(
                                dataManager,
                                keyword
                        );
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KataKamus>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        /** nothing to do in here */
                    }

                    @Override
                    public void onNext(@NonNull List<KataKamus> listDataKataKamusSearching) {
                        inputKeyword = editTextKeywordEnglishFragmentEnglishIndonesia.getText().toString();
                        Log.d(TAG, "inputKeyword onNext: " + inputKeyword);
                        Log.d(TAG, "listDataKatakamusSearching: " + Arrays.toString(listDataKataKamusSearching.toArray()));
                        listDataKataKamusEnglishIndonesia.clear();
                        listDataKataKamusEnglishIndonesia.addAll(listDataKataKamusSearching);
                        adapterSearchingKeyword.refreshData(listDataKataKamusSearching);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
