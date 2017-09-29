package com.ysn.dicodingandroiddeveloperexpert_kamus.model;

/**
 * Created by yudisetiawan on 9/29/17.
 */

public class KataKamus {

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
}
