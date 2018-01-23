/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yudisetiawan on 9/29/17.
 */

public class KataKamus implements Parcelable {

    private String fromWord;
    private String toWord;

    public KataKamus() {
    }

    public KataKamus(String fromWord, String toWord) {
        this.fromWord = fromWord;
        this.toWord = toWord;
    }

    public String getFromWord() {
        return fromWord;
    }

    public void setFromWord(String fromWord) {
        this.fromWord = fromWord;
    }

    public String getToWord() {
        return toWord;
    }

    public void setToWord(String toWord) {
        this.toWord = toWord;
    }

    @Override
    public String toString() {
        return "KataKamus{" +
                "fromWord='" + fromWord + '\'' +
                ", toWord='" + toWord + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fromWord);
        dest.writeString(this.toWord);
    }

    protected KataKamus(Parcel in) {
        this.fromWord = in.readString();
        this.toWord = in.readString();
    }

    public static final Parcelable.Creator<KataKamus> CREATOR = new Parcelable.Creator<KataKamus>() {
        @Override
        public KataKamus createFromParcel(Parcel source) {
            return new KataKamus(source);
        }

        @Override
        public KataKamus[] newArray(int size) {
            return new KataKamus[size];
        }
    };
}
