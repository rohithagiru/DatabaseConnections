package com.example.databaseconnections.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.databaseconnections.data.ToDoContract.TodoEntry;


public class DAO {

    TodoDbHelper dbHelper;
    SQLiteDatabase database;

    public DAO(Context context) {
        dbHelper = new TodoDbHelper(context);
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }
    public void createRow(String mtitle, String msubtitle, String mName, String mAddress){
        ContentValues values = new ContentValues();
        values.put(TodoEntry.COLUMN_NAME_TITLE,mtitle);
        values.put(TodoEntry.COLUMN_NAME_SUBTITLE,msubtitle);
        values.put(TodoEntry.COLUMN_NAME_NAME,mName);
        values.put(TodoEntry.COLUMN_NAME_ADDRESS,mAddress);
        database.insert(TodoEntry.TABLE_NAME,null,values);

    }
    public  String readRow(){
        Cursor cursor =
                //database.rawQuery("select * from notes",null);
                database.query(TodoEntry.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_SUBTITLE);
        int nameIndex = cursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_NAME);
        int addressIndex = cursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_ADDRESS);

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);
        String name = cursor.getString(nameIndex);
        String address = cursor.getString(addressIndex);


        return "Title: "+title+"\n"+"Sub Title: "+subtitle + "\n"+"Name: " + name + "\n"+"Address: "+address;
    }
    public void updateRow(){}
    public void deleteRow(){}

    public  Cursor readRows() {
        return database.query(TodoEntry.TABLE_NAME, null, null, null, null, null, null);

    }
    public void createRow(ToDoNote todoNote) {
        ContentValues values = new ContentValues();
        values.put(TodoEntry.COLUMN_NAME_TITLE,todoNote.getTitle());
        values.put(TodoEntry.COLUMN_NAME_SUBTITLE,todoNote.getSubTitle());
        values.put(TodoEntry.COLUMN_NAME_NAME,todoNote.getName());
        values.put(TodoEntry.COLUMN_NAME_ADDRESS,todoNote.getAddress());
        database.insert(TodoEntry.TABLE_NAME,null,values);
    }

}
