package com.example.administrator.shapanche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Zuojia extends AppCompatActivity {
    private Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    private String []data_list={"1","2","3","4"};
    private String[]data_list1={"1","2"};
    ArrayAdapter adapter;
    ArrayAdapter adapter2;
    private int cars;
    private int bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuojia);
        spinner=(Spinner)findViewById(R.id.Spinner);
        spinner2=(Spinner)findViewById(R.id.Spinner2);
        spinner3=(Spinner)findViewById(R.id.Spinner3);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data_list);
        spinner.setAdapter(adapter);
        adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data_list1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cars=i+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bus=i+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button control=(Button)findViewById(R.id.control);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Zuojia.this,MainActivity.class);
                intent.putExtra("car",cars);
                intent.putExtra("bus",bus);
                startActivity(intent);

            }
        });

    }
}
