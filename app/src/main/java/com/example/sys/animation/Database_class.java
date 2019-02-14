package com.example.sys.animation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database_class extends SQLiteOpenHelper {
    ArrayList <Map <String, String>> data, student_data;
    ArrayList <Map <String, String>> data1;
    public static final String DB_NAME = "student";
    public static final String TABLE_NAME = "table_name";
    public static final String HOUSE_NO = "houseno";
    public static final String STREET = "street";
    public static final String LANDMARK = "landmark";
    public static final String CITY = "city";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String DISTRICT = "district";
    public static final String STATE = "state";
    public static final String PINCODE = "pincode";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + EMAIL + " TEXT,"
                    + PASSWORD + " TEXT,"
                    + HOUSE_NO + " TEXT,"
                    + STREET + " TEXT,"
                    + LANDMARK + " TEXT,"
                    + CITY + " TEXT,"
                    + DISTRICT + " TEXT,"
                    + STATE + " TEXT,"
                    + PINCODE + " TEXT,"
                    + ")";

    public Database_class(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertValues(String house_str, String street_str, String landmark_Str, String city_str, String district_str, String state_str,String pincode_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HOUSE_NO, house_str);
        values.put(STREET, street_str);
        values.put(LANDMARK, landmark_Str);
        values.put(CITY, city_str);
        values.put(DISTRICT, district_str);
        values.put(STATE, state_str);
        values.put(PINCODE, pincode_str);
        sqLiteDatabase.insert(TABLE_NAME, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public void insertValues(String email_str, String password_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL, email_str);
        values.put(PASSWORD, password_str);

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Map<String, String>> getRetrive(String username, String password) {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + EMAIL + " = '" + username + "' and " + PASSWORD + " = '" + password + "'", null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();

                hmap.put(EMAIL, cursor.getString(cursor.getColumnIndex(EMAIL)));
                hmap.put(PASSWORD, cursor.getString(cursor.getColumnIndex(PASSWORD)));
                data.add(hmap);

            } while (cursor.moveToNext());
        }
        return data;
    }
    public ArrayList<Map<String, String>> getprofile(String email,String  house_str, String street_str, String landmark_Str, String city_str, String district_str, String state_str,String pincode_str ) {
        data1 = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + EMAIL + " = '" + email + "' and " + PASSWORD + " = '" + password + "'", null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();

                hmap.put(EMAIL, cursor.getString(cursor.getColumnIndex(EMAIL)));
                hmap.put(PASSWORD, cursor.getString(cursor.getColumnIndex(PASSWORD)));
                data1.add(hmap);

            } while (cursor.moveToNext());
        }
        return data1;
    }
}
