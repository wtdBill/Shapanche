package com.example.administrator.shapanche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Shezhi extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        editText1=(EditText)findViewById(R.id.Ip);
        editText2=(EditText)findViewById(R.id.duankou);
        button=(Button)findViewById(R.id.queren);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ip=editText1.getText().toString();
                String duankou=editText2.getText().toString();
                Intent intent=new Intent(Shezhi.this,Daolu.class);
                intent.putExtra("Ip",Ip);
                intent.putExtra("duankou",duankou);
                startActivity(intent);
            }
        });
    }
}
