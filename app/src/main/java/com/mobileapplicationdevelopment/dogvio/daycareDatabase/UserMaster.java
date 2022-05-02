package com.mobileapplicationdevelopment.dogvio.daycareDatabase;

import android.provider.BaseColumns;

public final class UserMaster {
    private UserMaster(){};


    public  static class  Users implements BaseColumns{
        public static final String TABLE_NAME = "BookingDayCare";

        public  static final String COLUMN_NAME_DOG_NAME = "dogname";
        public  static final String COLUMN_NAME_DOG_BREED = "dogbreed";
        public  static final String COLUMN_NAME_DOG_AGE = "dogage";
        public  static final String COLUMN_NAME_DOG_IN = "dogin";
        public  static final String COLUMN_NAME_DOG_OUT = "dogout";
        public  static final String COLUMN_NAME_DOG_PACKAGENO = "dogpackageno";
    }
}
