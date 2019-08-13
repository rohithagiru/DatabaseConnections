package com.example.databaseconnections;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.databaseconnections.data.ToDoContract.TodoEntry;

import com.example.databaseconnections.data.DAO;
import com.example.databaseconnections.data.ToDoNote;

public class MainActivity extends AppCompatActivity {

    DAO dao;
    EditText mtitle,msubtitle;
    EditText mName,mAddress;
    TextView mTextview;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtitle = findViewById(R.id.editTextTitle);
        msubtitle = findViewById(R.id.editTextSubTitle);
      mTextview = findViewById(R.id.textViewResult);
        mName = findViewById(R.id.editTextName);
        mAddress = findViewById(R.id.editTextAddress);
        dao = new DAO(this);
        dao.openDb();
        Cursor dataCursor = dao.readRows();
        adapter = new SimpleCursorAdapter(this,
                R.layout.simple_list_item,
                dataCursor,
                new String[]{TodoEntry.COLUMN_NAME_TITLE,TodoEntry.COLUMN_NAME_SUBTITLE,TodoEntry.COLUMN_NAME_NAME,TodoEntry.COLUMN_NAME_ADDRESS},
                new int[]{R.id.textViewTitle,R.id.textViewSubtitle,R.id.textViewName,R.id.textViewAddress}, 0 );

        ListView dbListView = findViewById(R.id.dbList);
        dbListView.setAdapter(adapter);

    }

    public void DBHandler(View view) {

        switch (view.getId()){
            case R.id.buttonPut:
                String title = mtitle.getText().toString();
                String subtitle = msubtitle.getText().toString();
                String name = mName.getText().toString();
                String address = mAddress.getText().toString();

                dao.createRow(new ToDoNote(title,subtitle,name,address));
                adapter.notifyDataSetChanged();

                break;
            case R.id.buttonGet:
                String result = dao.readRow();
                mTextview.setText(result);
                break;
        }
    }
}
