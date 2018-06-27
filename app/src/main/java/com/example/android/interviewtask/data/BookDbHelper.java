package com.example.android.interviewtask.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.interviewtask.data.BookContract.UserEntry;
import com.example.android.interviewtask.data.BookContract.ReadPagesEntry;

/**
 * Created by ahmed on 6/27/2018.
 */

public class BookDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "interview.db";
    public static final int DATABASE_VERSION = 1;

    public BookDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + "( "
                + UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserEntry.COLUMN_NAME + " TEXT NOT NULL);";
        String SQL_CREATE_READ_PAGES_TABLE = "CREATE TABLE " + ReadPagesEntry.TABLE_NAME + "( "
                + ReadPagesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ReadPagesEntry.COLUMN_FROM + " INTEGER NOT NULL,"
                + ReadPagesEntry.COLUMN_TO + " INTEGER NOT NULL,"
                + ReadPagesEntry.COLUMN_USER_ID + " INTEGER, FOREIGN KEY ("
                + ReadPagesEntry.COLUMN_USER_ID + ") REFERENCES "
                + UserEntry.TABLE_NAME + "( "
                + UserEntry._ID + " ) );";
        String SQL_INSERT_INTO_USER_TABLE1 = "INSERT INTO "
                + UserEntry.TABLE_NAME + " ( " + UserEntry.COLUMN_NAME + " ) "
                + " VALUES ( 'Jane' ); ";
        String SQL_INSERT_INTO_USER_TABLE2 = "INSERT INTO "
                + UserEntry.TABLE_NAME + " ( " + UserEntry.COLUMN_NAME + " ) "
                + " VALUES ( 'Ahmed' );";
        String SQL_INSERT_INTO_READ_PAGES_TABLE1 = "INSERT INTO "
                + ReadPagesEntry.TABLE_NAME
                + " ( " + ReadPagesEntry.COLUMN_FROM
                + ", " + ReadPagesEntry.COLUMN_TO
                + ", " + ReadPagesEntry.COLUMN_USER_ID
                + " ) "
                + " VALUES ( '1' , '20' , '1' ); ";
        String SQL_INSERT_INTO_READ_PAGES_TABLE2 = "INSERT INTO "
                + ReadPagesEntry.TABLE_NAME
                + " ( " + ReadPagesEntry.COLUMN_FROM
                + ", " + ReadPagesEntry.COLUMN_TO
                + ", " + ReadPagesEntry.COLUMN_USER_ID
                + " ) "
                + " VALUES ( '33' , '47' , '2' ); ";
        String SQL_INSERT_INTO_READ_PAGES_TABLE3 = "INSERT INTO "
                + ReadPagesEntry.TABLE_NAME
                + " ( " + ReadPagesEntry.COLUMN_FROM
                + ", " + ReadPagesEntry.COLUMN_TO
                + ", " + ReadPagesEntry.COLUMN_USER_ID
                + " ) "
                + " VALUES ( '9' , '30' , '1' ); ";
        String SQL_INSERT_INTO_READ_PAGES_TABLE4 = "INSERT INTO "
                + ReadPagesEntry.TABLE_NAME
                + " ( " + ReadPagesEntry.COLUMN_FROM
                + ", " + ReadPagesEntry.COLUMN_TO
                + ", " + ReadPagesEntry.COLUMN_USER_ID
                + " ) "
                + " VALUES ( '39' , '67' , '2' ); ";
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_READ_PAGES_TABLE);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_USER_TABLE1);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_USER_TABLE2);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_READ_PAGES_TABLE1);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_READ_PAGES_TABLE2);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_READ_PAGES_TABLE3);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_READ_PAGES_TABLE4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
