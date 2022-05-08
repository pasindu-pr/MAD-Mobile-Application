package com.mobileapplicationdevelopment.dogvio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.annotation.StringDef;

import java.util.ArrayList;
import java.util.List;

public class Doc_DbHandler extends SQLiteOpenHelper {

    private static final int Doc_VERSION  = 1;
    private static final String Doc_DB_NAME = "DogApp";
    private static final String Doc_TABLE_NAME = "Doc_Appointment";

    // Column names
    private static final String ID = "id";
    private static final String Date = "date";
    private static final String Time = "time";
    private static final String DrName = "nDrName";
    private static final String DogCount = "DogCount";
    private static final String UserName = "UserName";

    public Doc_DbHandler(@Nullable Context context) {
        super(context, Doc_DB_NAME, null, Doc_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE_QUERY = "CREATE TABLE "+Doc_TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Date + " TEXT,"
                +Time + " TEXT,"
                +DrName + " TEXT,"
                +DogCount+ " TEXT,"
                +UserName+" TEXT" +
                ");";
        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ Doc_TABLE_NAME;
        // Drop older table if existed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    // Add a single Appointment
    public void addApointment(Doctor_Appointment_Model_Class Doc_Model_class){
        SQLiteDatabase Doc_sqLiteDatabase = getWritableDatabase();

        ContentValues Doc_contentValues = new ContentValues();

        Doc_contentValues.put(Date,Doc_Model_class.getDate());
        Doc_contentValues.put(Time,Doc_Model_class.getTime());
        Doc_contentValues.put(DrName,Doc_Model_class.getDrName());
        Doc_contentValues.put(DogCount,Doc_Model_class.getDogCount());
        Doc_contentValues.put(UserName,Doc_Model_class.getUserName());

        //save Table
        Doc_sqLiteDatabase.insert(Doc_TABLE_NAME,null,Doc_contentValues);
        //close Database
        Doc_sqLiteDatabase.close();
    }

    //Count Appointment
    public int countAppointment(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + Doc_TABLE_NAME ;

        Cursor doc_cursor = db.rawQuery(query,null);
        return doc_cursor.getCount();
    }

    //get all appointments in to list
    public List<Doctor_Appointment_Model_Class> getAllAppointments(){

        List<Doctor_Appointment_Model_Class> Appointments = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+Doc_TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                // Create new Appointment object
                Doctor_Appointment_Model_Class Appointment = new Doctor_Appointment_Model_Class();

                Appointment.setId(cursor.getInt(0));
                Appointment.setDate(cursor.getString(1));
                Appointment.setTime(cursor.getString(2));
                Appointment.setDrName(cursor.getString(3));
                Appointment.setDogCount(cursor.getString(4));
                Appointment.setUserName(cursor.getString(5));

                Appointments.add(Appointment);
            }while (cursor.moveToNext());
        }
        return Appointments;
    }

    //Delete Appointment
    public void deleteAppointment(int id){
        SQLiteDatabase appointment_db = getWritableDatabase();
        appointment_db.delete(Doc_TABLE_NAME,ID +"=?",new String[]{String.valueOf(id)});
        appointment_db.close();
    }

    //Get a Single appointment
    public Doctor_Appointment_Model_Class getSingleAppointment(int id){
        SQLiteDatabase get_appointment_db =  getWritableDatabase();
       Cursor cursor = get_appointment_db.query(Doc_TABLE_NAME,new String[]{ID,Date,Time,DrName,DogCount,UserName},ID + " =?",new String[]{String.valueOf(id)},null,null,null);
        Doctor_Appointment_Model_Class doc_appoint  ;
        if(cursor != null){
                cursor.moveToFirst();
            doc_appoint = new Doctor_Appointment_Model_Class(
                cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return doc_appoint;
        }
        return null;
    }

    //Update a single appointment
    public int updateAppointment(Doctor_Appointment_Model_Class doc_appoi_model){
        SQLiteDatabase appointment_db = getWritableDatabase();

        ContentValues Doc_contentValues = new ContentValues();

        Doc_contentValues.put(Date,doc_appoi_model.getDate());
        Doc_contentValues.put(Time,doc_appoi_model.getTime());
        Doc_contentValues.put(DrName,doc_appoi_model.getDrName());
        Doc_contentValues.put(DogCount,doc_appoi_model.getDogCount());
        Doc_contentValues.put(UserName,doc_appoi_model.getUserName());

        int status = appointment_db.update(Doc_TABLE_NAME,Doc_contentValues,ID +" =?",new String[]{String.valueOf(doc_appoi_model.getId())});
        appointment_db.close();
        return status;
    }
}
