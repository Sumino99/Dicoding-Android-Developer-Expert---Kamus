package com.ysn.dicodingandroiddeveloperexpert_kamus.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.ysn.dicodingandroiddeveloperexpert_kamus.di.ApplicationContext;
import com.ysn.dicodingandroiddeveloperexpert_kamus.di.DatabaseInfo;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;

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
    public Long insertDataKamusIndonesiaToEnglish(KataKamus kataKamus) throws Exception{
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
}
