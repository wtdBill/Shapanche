package com.example.administrator.shapanche;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ypp on 2017/9/5.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_XINXI="create table Xinxi("
            +"_id integer primary key autoincrement,"
            +"time text,"
            +"name text,"
            +"price real)";
    private Context mcontext;
    public MyDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mcontext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_XINXI);
        Toast.makeText(mcontext,"success",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){}
}
