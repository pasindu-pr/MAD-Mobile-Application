package com.mobileapplicationdevelopment.dogvio.daycareDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.mobileapplicationdevelopment.dogvio.Booking_DayCare;
import com.mobileapplicationdevelopment.dogvio.ListDayCareAll;

import java.util.ArrayList;
import java.util.List;

public class DBDayCareHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME= "daycare";
    private static final String TABLE_NAME = "daycare";

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_DOG_NAME =  "dogname";
    public static final String COLUMN_NAME_BREED= "breed";
    public static final String COLUMN_NAME_DOG_AGE= "dogage";
    public static final String COLUMN_NAME_DATE_IN= "datein";
    public static final String COLUMN_NAME_DATE_OUT= "dateout";
    public static final String COLUMN_NAME_PACKAGEDOG = "packageNo";
    public static final String COLUMN_NAME_STARTED = "started";
    public static final String COLUMN_NAME_FINISHED= "finished";

    public DBDayCareHandler(Context context) {
        super(context, DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbdaycare) {

        //add data to database
        String TABLE_CREATE_QUERYDAYCARE = "CREATE TABLE " + TABLE_NAME +" "+
                "("
                +COLUMN_NAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_NAME_DOG_NAME+" TEXT,"
                +COLUMN_NAME_BREED + " TEXT,"
                +COLUMN_NAME_DOG_AGE+ " TEXT,"
                +COLUMN_NAME_DATE_IN+ " TEXT,"
                +COLUMN_NAME_DATE_OUT+ " TEXT,"
                +COLUMN_NAME_PACKAGEDOG+ " TEXT,"
                +COLUMN_NAME_STARTED+ " TEXT,"
                +COLUMN_NAME_FINISHED+ "  TEXT"+
                ");";

        /*run query*/
        dbdaycare.execSQL(TABLE_CREATE_QUERYDAYCARE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbdaycare, int oldversion, int newversion) {
            String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
            //drop older table if existed
            dbdaycare.execSQL(DROP_TABLE_QUERY);
            //create table again
           onCreate(dbdaycare);
    }

    /*Add booking*/
    public int addBooking(DayCareModule simpledaycare){
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();

            ContentValues contentValues = new ContentValues();

            contentValues.put(COLUMN_NAME_DOG_NAME,simpledaycare.getBedogname());
            contentValues.put(COLUMN_NAME_BREED,simpledaycare.getBedogbreed());
            contentValues.put(COLUMN_NAME_DOG_AGE,simpledaycare.getBedogage());
            contentValues.put(COLUMN_NAME_DATE_IN,simpledaycare.getBedogin());
            contentValues.put(COLUMN_NAME_DATE_OUT,simpledaycare.getBedogout());
            contentValues.put(COLUMN_NAME_PACKAGEDOG,simpledaycare.getBedogpackageno());
            contentValues.put(COLUMN_NAME_STARTED,simpledaycare.getStarted());
            contentValues.put(COLUMN_NAME_FINISHED,simpledaycare.getFinished());

            //save to table
           sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
           //close database
           sqLiteDatabase.close();

        return 0;
    }


    /*count history booking - calculation*/
     public int countBooking(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;

         Cursor cursor = sqLiteDatabase.rawQuery(query,null);
         return cursor.getCount();
    }

    /*Get All daycare booking history*/
    public List <DayCareModule> getAllBookingHistory(){

        List<DayCareModule> dayCareModules = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " +TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                //create new DayCareModule object
                DayCareModule dayCareModule = new DayCareModule();

                dayCareModule.setId(cursor.getInt(0));
                dayCareModule.setBedogname(cursor.getString(1));
                dayCareModule.setBedogbreed(cursor.getString(2));
                dayCareModule.setBedogage(cursor.getString(3));
                dayCareModule.setBedogin(cursor.getString(4));
                dayCareModule.setBedogout(cursor.getString(5));
                dayCareModule.setBedogpackageno(cursor.getString(6));
                dayCareModule.setStarted(cursor.getLong(7));
                dayCareModule.setFinished(cursor.getLong(8));

                //daymodules[object]
                dayCareModules.add(dayCareModule);
            }while (cursor.moveToNext());
        }

        return dayCareModules;
    }



    /*Delete booking new or old bookings*/
    public void deleteBooking(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
          sqLiteDatabase.delete(TABLE_NAME,COLUMN_NAME_ID+" =?",new String[]{String.valueOf(id)});
          sqLiteDatabase.close();
    }



    /*Get Singale Booking*/
    public DayCareModule getsingalBooking(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{COLUMN_NAME_ID,
                COLUMN_NAME_DOG_NAME,
                COLUMN_NAME_BREED,
                COLUMN_NAME_DOG_AGE,
                COLUMN_NAME_DATE_IN,
                COLUMN_NAME_DATE_OUT,
                COLUMN_NAME_PACKAGEDOG,
                COLUMN_NAME_STARTED,
                COLUMN_NAME_FINISHED}, COLUMN_NAME_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null);

        DayCareModule dayCareModule;
        if (cursor != null) {
            cursor.moveToFirst();
            dayCareModule = new DayCareModule(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getLong(7),
                    cursor.getLong(8)

            );
            return dayCareModule;

        }
        return null;
    }

    /*update single booking*/
    public int updatesingleBooking(DayCareModule simpledaycare) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME_DOG_NAME, simpledaycare.getBedogname());
        contentValues.put(COLUMN_NAME_BREED, simpledaycare.getBedogbreed());
        contentValues.put(COLUMN_NAME_DOG_AGE, simpledaycare.getBedogage());
        contentValues.put(COLUMN_NAME_DATE_IN, simpledaycare.getBedogin());
        contentValues.put(COLUMN_NAME_DATE_OUT, simpledaycare.getBedogout());
        contentValues.put(COLUMN_NAME_PACKAGEDOG, simpledaycare.getBedogpackageno());
        contentValues.put(COLUMN_NAME_STARTED, simpledaycare.getStarted());
        contentValues.put(COLUMN_NAME_FINISHED, simpledaycare.getFinished());

        int status = sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(simpledaycare.getId())});

        sqLiteDatabase.close();
        return status;
    }


}
