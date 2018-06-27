package com.example.android.interviewtask.data;

import android.provider.BaseColumns;

/**
 * Created by ahmed on 6/27/2018.
 */

public class BookContract {

    public static final class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "User";
        public static final String _ID = "id";
        public static final String COLUMN_NAME = "name";
    }

    public static final class ReadPagesEntry implements BaseColumns {
        public static final String TABLE_NAME = "ReadPages";
        public static final String _ID = "id";
        public static final String COLUMN_FROM = "_from";
        public static final String COLUMN_TO = "_to";
        public static final String COLUMN_USER_ID = "user_id";
        public static final int BOOK_PAGES_NUMBER = 70;
    }
}
