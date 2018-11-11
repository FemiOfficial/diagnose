package com.example.alayesanmifemi.diagnose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alayesanmi Femi on 24/09/2018.
 */

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "diagnosis.db";
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID_USERS = "id";
    private static final String COLUMN_USERNAME_USERS = "username";
    private static final String COLUMN_EMAIL_USERS = "email";
    private static final String COLUMN_PASSWORD_USERS = "password";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME , factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT );",
                TABLE_USERS, COLUMN_ID_USERS, COLUMN_USERNAME_USERS, COLUMN_EMAIL_USERS, COLUMN_PASSWORD_USERS);
        db.execSQL(query);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
    public void createUser(User user){
        ContentValues values = new ContentValues();
        values.put( COLUMN_USERNAME_USERS, user.getUsername());
        values.put( COLUMN_EMAIL_USERS, user.getEmail());
        values.put( COLUMN_PASSWORD_USERS, user.getPassword());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public String[] userProfile(String pin) {
        String[] columns = {
                COLUMN_ID_USERS, COLUMN_EMAIL_USERS,
                COLUMN_EMAIL_USERS, COLUMN_PASSWORD_USERS
        };
        String[] selectionsArgs = { pin };
        SQLiteDatabase db = getWritableDatabase();
        String query = COLUMN_EMAIL_USERS + " = ?" ;
        Cursor c = db.query(TABLE_USERS, columns, query, selectionsArgs, null,null,null);
        c.moveToFirst();
        String[] dbString = new String[4];
        if(c.getCount() != 0) {
            int column_id = c.getColumnIndex("id");
            int column_password = c.getColumnIndex("password");
            int column_email = c.getColumnIndex("email");
            int column_username = c.getColumnIndex("user");
            dbString[0] = c.getString(column_password);
            dbString[1] = c.getString(column_email);
            dbString[2] = c.getString(column_id);
            dbString[3] = c.getString(column_username);
        }
        c.close();
        db.close();
        return dbString;
    }
    public boolean checkUser(String pin){
        String[] columns = {
                COLUMN_ID_USERS
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection =  COLUMN_PASSWORD_USERS + " = ?";
        String[] selectionsArgs = { pin };

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionsArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
}
