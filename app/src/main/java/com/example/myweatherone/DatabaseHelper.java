package com.example.myweatherone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import static com.android.volley.VolleyLog.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "Searched_cities";
    private static final String COL1 = "ID";
    private static final String COL2 = "city_name";
    private static final String COL3 = "temperature";
    private static final String COL4 = "humidity";
    private static final String COL5 = "city_coords";
    private static final String COL6 = "search_date";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addData(String city_name, String temperature, String humidity, String city_coord, String search_date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, city_name);
        contentValues.put(COL3, temperature);
        contentValues.put(COL4, humidity);
        contentValues.put(COL5, city_coord);
        contentValues.put(COL6, search_date);

        Log.d(TAG, "addData: Adding " + city_name + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        String delete_50 = "Delete from " + TABLE_NAME + " where " + COL1
                + " not in ( select " + COL1 + " from " + TABLE_NAME + " order by " + COL6 + " desc limit 50)";
        db.execSQL(delete_50);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " order by " + COL6 + " desc";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
