package com.example.administrator.shapanche;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Xinxi extends AppCompatActivity {
    private MyDatabaseHelper databaseHelper;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinxi);
        listView=(ListView)findViewById(R.id.lllll);
        databaseHelper=new MyDatabaseHelper(this,"Xinxi.db",null,1);
        SQLiteDatabase database=databaseHelper.getWritableDatabase();
        Cursor cursor=database.query("Xinxi",null,null,null,null,null,null);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(getBaseContext(),R.layout.danhang,cursor,
                new String[]{"time","name","price"},new int[]{R.id.shijian,R.id.cheliang,R.id.jiage});
        listView.setAdapter(adapter);
    }
}
