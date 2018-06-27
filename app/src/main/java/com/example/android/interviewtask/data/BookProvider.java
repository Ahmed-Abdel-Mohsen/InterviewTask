package com.example.android.interviewtask.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.Pair;

import com.example.android.interviewtask.data.BookContract.ReadPagesEntry;
import com.example.android.interviewtask.data.BookContract.UserEntry;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ahmed on 6/27/2018.
 */

public class BookProvider {
    private static BookDbHelper dbHelper;
    private Context context;

    public BookProvider(Context context) {
        dbHelper = new BookDbHelper(context);
    }

    private Cursor query(String query, String[] param) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        return database.rawQuery(query, param);
    }

    public ArrayList<String> getIDs() {
        String QUERY = "SELECT " + UserEntry._ID
                + " FROM " + UserEntry.TABLE_NAME;
        String[] params = new String[]{};
        Cursor cursor = query(QUERY, params);
        ArrayList<String> ids = new ArrayList<>();
        while (cursor.moveToNext()) {
            ids.add(cursor.getString(cursor.getColumnIndex(UserEntry._ID)));
        }
        return ids;
    }

    public ArrayList<User> getAllUsers() {
        String QUERY = "SELECT * FROM " + ReadPagesEntry.TABLE_NAME
                + " INNER JOIN " + UserEntry.TABLE_NAME
                + " ON " + UserEntry.TABLE_NAME
                + "." + UserEntry._ID
                + " = " + ReadPagesEntry.COLUMN_USER_ID
                + " order by "
                + ReadPagesEntry.COLUMN_USER_ID
                + " ;";
        String[] params = new String[]{};
        Cursor cursor = query(QUERY, params);
        ArrayList<User> users = new ArrayList<>();

        User user = new User();
        while (cursor.moveToNext()) {
            if (user.getId() == cursor.getInt(cursor.getColumnIndex(ReadPagesEntry.COLUMN_USER_ID))) {
                Log.e("if", cursor.getString(5));
                Pair<Integer, Integer> temp = new Pair<>(cursor.getInt(cursor.getColumnIndex(ReadPagesEntry.COLUMN_FROM))
                        , cursor.getInt(cursor.getColumnIndex(ReadPagesEntry.COLUMN_TO)));
                users.get(users.size() - 1).addReadPages(temp);
            } else {
                Log.e("else", cursor.getString(5));
                user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(ReadPagesEntry.COLUMN_USER_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_NAME)));
                Pair<Integer, Integer> temp = new Pair<>(cursor.getInt(cursor.getColumnIndex(ReadPagesEntry.COLUMN_FROM))
                        , cursor.getInt(cursor.getColumnIndex(ReadPagesEntry.COLUMN_TO)));
                user.addReadPages(temp);
                users.add(user);
            }
        }
        return users;
    }
}