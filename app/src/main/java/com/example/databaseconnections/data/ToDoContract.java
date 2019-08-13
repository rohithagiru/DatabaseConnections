package com.example.databaseconnections.data;

import android.provider.BaseColumns;

public class ToDoContract {
    private ToDoContract() {}

    /* Inner class that defines the table contents */
    public static class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "address";

    }
}
