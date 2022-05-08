package com.mobileapplicationdevelopment.dogvio.HealthCareMealDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHealthCareHandler extends SQLiteOpenHelper {


    private static final int VERSION = 1;
    private static final String DB_NAME= "healthcaremeal";
    private static final String TABLE_NAME = "healthcaremeall";

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_MORNING =  "mealmorning";
    public static final String COLUMN_NAME_NOON= "mealnoon";
    public static final String COLUMN_NAME_NIGHT= "mealnight";
    public static final String COLUMN_NAME_DAY= "mealday";
    public static final String COLUMN_NAME_STARTED = "started";
    public static final String COLUMN_NAME_FINISHED= "finished";

    public DBHealthCareHandler(@Nullable Context context)  {
        super(context, DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbhealthcaremeal) {
        //add data to database
        String TABLE_CREATE_QUERYHEALTHCAREMEAL = "CREATE TABLE " + TABLE_NAME +" "+
                "("
                +COLUMN_NAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_NAME_MORNING+" TEXT,"
                +COLUMN_NAME_NOON + " TEXT,"
                +COLUMN_NAME_NIGHT+ " TEXT,"
                +COLUMN_NAME_DAY+ " TEXT,"
                +COLUMN_NAME_STARTED+ " TEXT,"
                +COLUMN_NAME_FINISHED+ "  TEXT"+
                ");";

        /*run query*/
        dbhealthcaremeal.execSQL(TABLE_CREATE_QUERYHEALTHCAREMEAL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase dbhealthcaremeal, int oldversion, int newversion) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        //drop older table if existed
        dbhealthcaremeal.execSQL(DROP_TABLE_QUERY);
        //create table again
        onCreate(dbhealthcaremeal);

    }

    /*Insert Meal*/
    public void addmeal(HealthCareMealModule healthCareMealModule){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME_MORNING, healthCareMealModule.getMorningmeal());
        contentValues.put(COLUMN_NAME_NOON, healthCareMealModule.getNoonmeal());
        contentValues.put(COLUMN_NAME_NIGHT, healthCareMealModule.getNigthmeal());
        contentValues.put(COLUMN_NAME_DAY, healthCareMealModule.getDaymeal());
        contentValues.put(COLUMN_NAME_STARTED, healthCareMealModule.getStarted());
        contentValues.put(COLUMN_NAME_FINISHED, healthCareMealModule.getFinished());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        //close database
        sqLiteDatabase.close();


    }


    /*count history meal added - calculation*/
    public int countMeal(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }

    /*Get All Meals*/
    public List<HealthCareMealModule> getAllMeals(){

        List<HealthCareMealModule> healthCareMealModules = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                //create new object
                HealthCareMealModule healthCareMealModule = new HealthCareMealModule();

                //get column
                healthCareMealModule.setId(cursor.getInt(0));
                healthCareMealModule.setMorningmeal(cursor.getString(1));
                healthCareMealModule.setNoonmeal(cursor.getString(2));
                healthCareMealModule.setNigthmeal(cursor.getString(3));
                healthCareMealModule.setDaymeal(cursor.getString(4));
                healthCareMealModule.setStarted(cursor.getLong(5));
                healthCareMealModule.setFinished(cursor.getLong(6));

                // healthCareMealModule
                healthCareMealModules.add(healthCareMealModule);

            }while (cursor.moveToNext());
        }
        return healthCareMealModules;
    }



    /*Delete Meal*/
    public void deleteMeal(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,COLUMN_NAME_ID+" =?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    /*get single meal*/
    public HealthCareMealModule getsingalMeal(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{
                COLUMN_NAME_ID,
                COLUMN_NAME_MORNING,
                COLUMN_NAME_NOON,
                COLUMN_NAME_NIGHT,
                COLUMN_NAME_DAY,
                COLUMN_NAME_STARTED,
                COLUMN_NAME_FINISHED}, COLUMN_NAME_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null);

        HealthCareMealModule healthCareMealModule;
        if (cursor != null) {
            cursor.moveToFirst();
            healthCareMealModule = new   HealthCareMealModule(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getLong(5),
                    cursor.getLong(6)


            );
            return  healthCareMealModule;

        }
        return null;
    }

    /*update Meal*/
    public int updatesingleBooking(HealthCareMealModule healthCareMealModule) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME_MORNING,healthCareMealModule.getMorningmeal());
        contentValues.put(COLUMN_NAME_NOON,healthCareMealModule.getNoonmeal());
        contentValues.put(COLUMN_NAME_NIGHT, healthCareMealModule.getNigthmeal());
        contentValues.put(COLUMN_NAME_DAY, healthCareMealModule.getDaymeal());
        contentValues.put(COLUMN_NAME_STARTED, healthCareMealModule.getStarted());
        contentValues.put(COLUMN_NAME_FINISHED,healthCareMealModule.getFinished());

        int status = sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(healthCareMealModule.getId())});

        sqLiteDatabase.close();
        return status;
    }

}
