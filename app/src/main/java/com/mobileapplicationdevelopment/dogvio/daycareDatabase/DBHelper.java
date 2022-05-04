package com.mobileapplicationdevelopment.dogvio.daycareDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DogApp.db";

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, 1);
    }

    /*create booking sql*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_BOOKING =
                "CREATE TABLE " + UserMaster.Users.TABLE_NAME + " (" +
                        UserMaster.Users._ID+ " INTEGER PRIMARY KEY," +
                        UserMaster.Users.COLUMN_NAME_DOG_NAME+ " TEXT, "+
                        UserMaster.Users.COLUMN_NAME_DOG_BREED+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_DOG_AGE+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_DOG_IN+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_DOG_OUT+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_DOG_PACKAGENO+ " TEXT)";

        db.execSQL(SQL_CREATE_BOOKING);
    }

    public Long addBooking(String Bdogname,String Bdogbreed, String Bdogage,String  Bdogin,String Bdogout,String Bdogpackage){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserMaster.Users.COLUMN_NAME_DOG_NAME, Bdogname);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_BREED, Bdogbreed);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_AGE, Bdogage);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_IN, Bdogin);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_OUT, Bdogout);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_PACKAGENO,Bdogpackage);

        return db.insert(UserMaster.Users.TABLE_NAME,null,values);
    }

    public  boolean updateBooking(String Bdogname,String Bdogbreed, String Bdogage,String  Bdogin,String Bdogout,String Bdogpackage){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(UserMaster.Users.COLUMN_NAME_DOG_NAME, Bdogname);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_BREED, Bdogbreed);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_AGE, Bdogage);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_IN, Bdogin);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_OUT, Bdogout);
        values.put(UserMaster.Users.COLUMN_NAME_DOG_PACKAGENO,Bdogpackage);

        db.update(UserMaster.Users.TABLE_NAME,values,"ID = ?", new String[]{ Bdogpackage });
        return true;
    }

    public void deletebooking(String id) {
        SQLiteDatabase db = getReadableDatabase();

        String selection = UserMaster.Users._ID + "ID ?";
        String[] stringArgs = {id};

        db.delete(UserMaster.Users.TABLE_NAME, selection, stringArgs);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
