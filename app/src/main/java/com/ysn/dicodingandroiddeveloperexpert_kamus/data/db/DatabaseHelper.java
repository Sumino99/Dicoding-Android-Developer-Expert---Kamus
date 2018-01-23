/*
 * Created by Yudi Setiawan on 1/23/18 11:01 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 1/23/18 11:00 PM
 */

package com.ysn.dicodingandroiddeveloperexpert_kamus.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ApplicationContext;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.DatabaseInfo;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by yudisetiawan on 9/28/17.
 */

@Singleton
public class DatabaseHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();

    // Kamus Indonesia To English
    public static final String KAMUS_INDONESIA_TABLE_NAME = "indonesia_english";
    public static final String KAMUS_INDONESIA_COLUMN_ID = "id";
    public static final String KAMUS_INDONESIA_COLUMN_FROM_WORD = "fromWord";
    public static final String KAMUS_INDONESIA_COLUMN_TO_WORD = "toWord";

    // Kamus English to Indonesia
    public static final String KAMUS_ENGLISH_TABLE_NAME = "english_indonesia";
    public static final String KAMUS_ENGLISH_COLUMN_ID = "id";
    public static final String KAMUS_ENGLISH_COLUMN_FROM_WORD = "fromWord";
    public static final String KAMUS_ENGLISH_COLUMN_TO_WORD = "toWord";

    @Inject
    public DatabaseHelper(@ApplicationContext Context context,
                          @DatabaseInfo String databaseName,
                          @DatabaseInfo Integer version) {
        super(context, databaseName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        tableKamusIndonesiaEnglishCreateStatements(sqLiteDatabase);
        tableKamusEnglishIndonesiaCreateStatements(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KAMUS_INDONESIA_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KAMUS_ENGLISH_TABLE_NAME);
    }

    private void tableKamusIndonesiaEnglishCreateStatements(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE IF NOT EXISTS " + KAMUS_INDONESIA_TABLE_NAME + " "
                            + "("
                            + KAMUS_INDONESIA_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + KAMUS_INDONESIA_COLUMN_FROM_WORD + " TEXT, "
                            + KAMUS_INDONESIA_COLUMN_TO_WORD + " TEXT"
                            + ")"
            );
        } catch (SQLiteException sqle) {
            sqle.printStackTrace();
        }
    }

    private void tableKamusEnglishIndonesiaCreateStatements(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE IF NOT EXISTS " + KAMUS_ENGLISH_TABLE_NAME + " "
                            + "("
                            + KAMUS_ENGLISH_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + KAMUS_ENGLISH_COLUMN_FROM_WORD + " TEXT, "
                            + KAMUS_ENGLISH_COLUMN_TO_WORD + " TEXT"
                            + ")"
            );
        } catch (SQLiteException sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     * Insert data to table KAMUS INDONESIA TO ENGLISH
     */
    public Long insertDataKamusIndonesiaToEnglish(KataKamus kataKamus) throws Exception {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(KAMUS_INDONESIA_COLUMN_FROM_WORD, kataKamus.getFromWord());
            contentValues.put(KAMUS_INDONESIA_COLUMN_TO_WORD, kataKamus.getToWord());
            return sqLiteDatabase.insert(
                    KAMUS_INDONESIA_TABLE_NAME,
                    null,
                    contentValues
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Insert data to table KAMUS ENGLISH TO INDONESIA
     */
    public Long insertDataKamusEnglishToIndonesia(KataKamus kataKamus) throws Exception {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(KAMUS_ENGLISH_COLUMN_FROM_WORD, kataKamus.getFromWord());
            contentValues.put(KAMUS_ENGLISH_COLUMN_TO_WORD, kataKamus.getToWord());
            return sqLiteDatabase.insert(
                    KAMUS_ENGLISH_TABLE_NAME,
                    null,
                    contentValues
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Delete all data in table KAMUS INDONESIA TO ENGLISH
     */
    public int deleteDataKamusIndonesiaToEnglish() throws Exception {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            return sqLiteDatabase.delete(
                    KAMUS_ENGLISH_TABLE_NAME,
                    null,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Delete all data in table KAMUS ENGLISH TO INDONESIA
     */
    public int deleteDataKamusEnglishToIndonesia() throws Exception {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            return sqLiteDatabase.delete(
                    KAMUS_INDONESIA_TABLE_NAME,
                    null,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int itemCountDataKamusEnglishToIndonesia() throws Resources.NotFoundException, NullPointerException {
        int itemCount;
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * FROM " + KAMUS_ENGLISH_TABLE_NAME,
                    null,
                    null
            );
            itemCount = cursor.getCount();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return itemCount;
    }

    public int itemCountDataKamusIndonesiaToEnglish() throws Resources.NotFoundException, NullPointerException {
        int itemCount;
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * FROM " + KAMUS_INDONESIA_TABLE_NAME,
                    null,
                    null
            );
            itemCount = cursor.getCount();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return itemCount;
    }

    public List<KataKamus> getDataEnglishIndonesiaByKeyword(String keyword) throws Resources.NotFoundException, NullPointerException {
        List<KataKamus> listDataEnglishIndonesia = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * FROM " + KAMUS_ENGLISH_TABLE_NAME
                            + " WHERE "
                            + KAMUS_ENGLISH_COLUMN_FROM_WORD + " LIKE '%" + keyword + "%'",
                    null
            );
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    KataKamus kataKamus = new KataKamus(
                            cursor.getString(cursor.getColumnIndex(KAMUS_ENGLISH_COLUMN_FROM_WORD)),
                            cursor.getString(cursor.getColumnIndex(KAMUS_ENGLISH_COLUMN_TO_WORD))
                    );
                    if (listDataEnglishIndonesia.size() > 0) {
                        boolean isAlreadyAdded = false;
                        for (KataKamus kataKamusSave : listDataEnglishIndonesia) {
                            if (kataKamusSave.getFromWord().equals(kataKamus.getFromWord())) {
                                isAlreadyAdded = true;
                                break;
                            }
                        }
                        if (!isAlreadyAdded) {
                            listDataEnglishIndonesia.add(kataKamus);
                        }
                    } else {
                        listDataEnglishIndonesia.add(kataKamus);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataEnglishIndonesia;
    }

    public List<KataKamus> getDataIndonesiaEnglishByKeyword(String keyword) throws Resources.NotFoundException {
        List<KataKamus> listDataIndonesiaEnglish = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * FROM " + KAMUS_INDONESIA_TABLE_NAME
                            + " WHERE "
                            + KAMUS_INDONESIA_COLUMN_FROM_WORD + " LIKE '%" + keyword + "%'",
                    null
            );
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    KataKamus kataKamus = new KataKamus(
                            cursor.getString(cursor.getColumnIndex(KAMUS_INDONESIA_COLUMN_FROM_WORD)),
                            cursor.getString(cursor.getColumnIndex(KAMUS_INDONESIA_COLUMN_TO_WORD))
                    );
                    if (listDataIndonesiaEnglish.size() > 0) {
                        boolean isAlreadyAdded = false;
                        for (KataKamus kataKamusSave : listDataIndonesiaEnglish) {
                            if (kataKamusSave.getFromWord().equals(kataKamus.getFromWord())) {
                                isAlreadyAdded = true;
                                break;
                            }
                        }
                        if (!isAlreadyAdded) {
                            listDataIndonesiaEnglish.add(kataKamus);
                        }
                    } else {
                        listDataIndonesiaEnglish.add(kataKamus);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataIndonesiaEnglish;
    }

    public int insertListDataKamusEnglishToIndonesia(List<KataKamus> listKataKamusEnglishIndonesia) throws Resources.NotFoundException {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            String queryInsert = "INSERT INTO " + KAMUS_ENGLISH_TABLE_NAME
                    + " ("
                    + KAMUS_ENGLISH_COLUMN_FROM_WORD + ", " + KAMUS_ENGLISH_COLUMN_TO_WORD
                    + ") "
                    + "VALUES "
                    + "(?, ?)";
            sqLiteDatabase.beginTransaction();
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(queryInsert);
            for (KataKamus kataKamusEnglishIndonesia : listKataKamusEnglishIndonesia) {
                sqLiteStatement.bindString(1, kataKamusEnglishIndonesia.getFromWord());
                sqLiteStatement.bindString(2, kataKamusEnglishIndonesia.getToWord());
                sqLiteStatement.execute();
                sqLiteStatement.clearBindings();
            }
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    public int insertListDataKamusIndonesiaToEnglish(List<KataKamus> listKataKamusIndonesiaEnglish) throws Resources.NotFoundException {
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            String queryInsert = "INSERT INTO " + KAMUS_INDONESIA_TABLE_NAME
                    + " ("
                    + KAMUS_INDONESIA_COLUMN_FROM_WORD + ", " + KAMUS_INDONESIA_COLUMN_TO_WORD
                    + ") "
                    + "VALUES "
                    + "(?, ?)";
            sqLiteDatabase.beginTransaction();
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(queryInsert);
            for (KataKamus kataKamusIndonesiaEnglish : listKataKamusIndonesiaEnglish) {
                sqLiteStatement.bindString(1, kataKamusIndonesiaEnglish.getFromWord());
                sqLiteStatement.bindString(2, kataKamusIndonesiaEnglish.getToWord());
                sqLiteStatement.execute();
                sqLiteStatement.clearBindings();
            }
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
