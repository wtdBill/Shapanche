package com.example.administrator.shapanche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Gongjiaoo extends AppCompatActivity {
    private List<Point> pointList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gongjiaoo);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PointAdapter adapter=new PointAdapter(pointList);
        recyclerView.setAdapter(adapter);

    }



    }
