package com.example.administrator.shapanche;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.administrator.shapanche.http.Huanjing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class Daolu extends AppCompatActivity {
    String mEdUrl = "http://";
    Button button;
    TextView textView,pm,shidu,wendu,co,light;
    private static final String TAG = "Daolu";

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daolu);
        pm=(TextView)findViewById(R.id.TextView1);
        shidu=(TextView)findViewById(R.id.TextView2);
        wendu=(TextView)findViewById(R.id.TextView3);
        co=(TextView)findViewById(R.id.TextView4);
        light=(TextView)findViewById(R.id.TextView6);
        videoView=(VideoView)findViewById(R.id.videoview);
        MediaController mc=new MediaController(Daolu.this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse("android.resource://com.example.administrator.shapanche/"+R.raw.pm));
        videoView.requestFocus();
        try {
            videoView.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(Daolu.this,"完毕",Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent=getIntent();
        final String Ip=intent.getStringExtra("Ip");
        final String duankou=intent.getStringExtra("duankou");
        button=(Button)findViewById(R.id.b1);
        textView=(TextView)findViewById(R.id.client);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String strUrl1;
                String strUrl;
                String strJson = "{}";
                com.example.administrator.shapanche.http.HttpThread jsonThread;
//                strUrl1 = "192.168.1.136:8890";
//                strUrl=strUrl1+"transportservice";
                strUrl1 = mEdUrl + Ip + ":" + duankou + "/type/jason/action/";
                strUrl = strUrl1 + "GetAllSense";
//                strUrl="http://www.sojson.com/open/api/weather/json.shtml?city=北京";
                strJson = "{}";
                System.out.println("url为：" + strUrl);
                System.out.println("strJson为：" + strJson);
                jsonThread = new com.example.administrator.shapanche.http.HttpThread(
                        getBaseContext(), mHandler);
                jsonThread.setUrl(strUrl);
                jsonThread.setJsonstring(strJson);
                jsonThread.start();

            }
        });
//        if (ContextCompat.checkSelfPermission(Daolu.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
//        PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(Daolu.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);}
//        else {
//            initVideoPath();
      }
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
//			if (msg.what == 1) {
            if (msg.what == 1 || msg.what == 901) {

                String strWebContent = null;
                strWebContent = (String) msg.obj;
//                parseJSONWithJSONObject(strWebContent);
                textView.setText(strWebContent);
                rest(strWebContent);

            }
        }
    };
    private void rest(String ss){
        Gson gson=new GsonBuilder().create();
        Huanjing huanjing=gson.fromJson(ss,Huanjing.class);
        String tem=huanjing.getTemperature()+"";
        String pm=huanjing.get_$Pm2545()+"";
        String shidu=huanjing.getHumidity()+"";
        String light=huanjing.getLightIntensity()+"";
        String co=huanjing.getCo2()+"";
        Log.d(TAG, tem+"");
        set(tem,pm,shidu,light,co);
    }
    private  void set(final String tem1, final String pm1, final String shidu1, final String light1, final String co1){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pm.setText(pm1);
                co.setText(co1);
                shidu.setText(shidu1);
                wendu.setText(tem1);
                light.setText(light1);
            }
        });
    }
//    }//初始化MediaPlayer
//    private void initVideoPath(){
//        File file=new File(Environment.getExternalStorageDirectory(),"pm.mp4");
//        videoView.setVideoPath(file.getPath());//指定文件路径
//    }
}
