package com.example.administrator.shapanche;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private static final String TAG = "MainActivity";
    int x;
    int y;
    String time;
    ImageView bus1;
    ImageView bus2;
    ImageView car1;
    ImageView car2;
    ImageView shezhi;
    private DrawerLayout mDrawerLayout;
    private String[] data={"我的座驾","我的路况","停车查询","公交查询","道路环境","ETC缴费"};
    private int che[]={R.id.bus1,R.id.bus2,R.id.car1,R.id.car1,R.id.car2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shezhi=(ImageView)findViewById(R.id.shezhi);
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Shezhi.class));
            }
        });
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        FrameLayout frameLayout=(FrameLayout)findViewById(R.id.FrameLayout);
        final Intent intent=getIntent();

        final ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
        navigationView.setCheckedItem(R.id.Zuojia1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=item.getItemId();
                switch (i){
                    case R.id.Zuojia1:
                        startActivity(new Intent(MainActivity.this,Zuojia.class));
                        finish();
                        break;
                    case R.id.Tingche1:
                        startActivity(new Intent(MainActivity.this,Tingche.class));
                        break;
                    case R.id.Daolu1:
                        startActivity(new Intent(MainActivity.this,Daolu.class));
                        break;
                    case R.id.ETC1:
                        startActivity(new Intent(MainActivity.this,ETC.class));
                        break;
                    case R.id.Gongjiao1:
                        startActivity(new Intent(getBaseContext(),Gongjiaoo.class));
                        break;
                    default:
                }
                return true;
            }
        });
        dbHelper=new MyDatabaseHelper(this,"Xinxi.db",null,1);
        FloatingActionButton flo=(FloatingActionButton)findViewById(R.id.Float);
        flo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LitePal.getDatabase();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                time = formatter.format(curDate);
//                x=bus1.getTop();
//                y=bus1.getLeft();
//                Point point=new Point();
//                point.setX(x);
//                point.setY(y);
//                point.setTime(time);
//                point.save();
//                int a=bus1.getLeft();
//                int b=bus1.getRight();
//                int c=bus1.getTop();
//                int d=bus1.getBottom();
//                Log.d(TAG, "位置是"+a+"you"+b+"shang"+c+"xia"+d);
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("time",time);
                values.put("name","公交车1");
                values.put("price","5");
                db.insert("Xinxi",null,values);
            }
        });
//       ListView listView=(ListView)findViewById(R.id.Listview);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);
////        adapter.notifyDataSetChanged();动态更新ListView
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                switch (position){
//                    case 0:
//                        startActivity(new Intent(MainActivity.this,Zuojia.class));
//                        finish();
//                        break;
//                    case 2:
//                        startActivity(new Intent(MainActivity.this,Tingche.class));
//                        break;
//                    case 4:
//                        startActivity(new Intent(MainActivity.this,Daolu.class));
//                        break;
//                    case 5:
//                        startActivity(new Intent(MainActivity.this,ETC.class));
//                        break;
//                    default:
//                }
//            }
//        });
        bus1=(ImageView)findViewById(R.id.bus1);
        bus2=(ImageView)findViewById(R.id.bus2);
        car1=(ImageView)findViewById(R.id.car1);
        car2=(ImageView)findViewById(R.id.car2);
        final Animator animator5=AnimatorInflater.loadAnimator(getBaseContext(),
                R.animator.donghua4);
        animator5.setTarget(car2);
        animator5.start();
        animator5.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator animator1=ObjectAnimator.ofFloat(car2,"rotation",-270f,-360);
                animator1.setDuration(2000);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(animator1).before(animator5);
                animatorSet.start();
            }
        });
        final Animator animator4=AnimatorInflater.loadAnimator(getBaseContext(),R.animator.donghua3);
        animator4.setTarget(car1);
        animator4.start();
        animator4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator animator1=ObjectAnimator.ofFloat(car1,"rotation",-270f,-360);
                animator1.setDuration(2000);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(animator1).before(animator4);
                animatorSet.start();
            }
        });


        final Animator animator= AnimatorInflater.loadAnimator(getBaseContext()
                ,R.animator.donghuaa);
        animator.setTarget(bus1);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator animator1=ObjectAnimator.ofFloat(bus1,"rotation",-270f,-360);
                animator1.setDuration(2000);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(animator1).before(animator);
                animatorSet.start();
            }
        });
        final Animator animator2=AnimatorInflater.loadAnimator(getBaseContext()
                ,R.animator.donghua2);
        animator2.setTarget(bus2);
        animator2.start();
        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator animator3=ObjectAnimator.ofFloat
                        (bus2,"rotation",-270f,-360f);
                animator3.setDuration(2000);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(animator3).before(animator2);
                animatorSet.start();
            }
        });
        int cars=intent.getIntExtra("car",1);
        int bus=intent.getIntExtra("bus",3);
        //判断Zuojia中传来的值来改变小车的数量
        switch (cars){
            case 1:
                frameLayout.removeView(car2);
                break;
            case 2:
                break;
            default:
        }
        switch (bus){
            case 1:
                frameLayout.removeView(bus1);
                super.onResume();
                Toast.makeText(MainActivity.this,"aaaaaaaaaaaa",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this,"zzzzzzzz",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        final int a=Math.abs(bus1.getLeft()-bus1.getRight());
        new Thread(new Runnable() {
            @Override
            public void run() {
                int location1[]=new int[2];
                car1.getLocationOnScreen(location1);
                int X1=location1[0];
                int Y1=location1[1];
                int location2[]=new int[2];
                car2.getLocationOnScreen(location2);
                int X2=location2[0];
                int Y2=location2[1];
                int location3[]=new int[2];
                bus1.getLocationOnScreen(location3);
                int X3=location3[0];
                int Y3=location3[1];
                int location4[]=new int[2];
                bus2.getLocationOnScreen(location4);
                int X4=location4[0];
                int Y4=location4[1];
                try {
                    double a1=Math.sqrt(Math.pow(X1-X2,2)+Math.pow(Y1-Y2,2));
                    int b1=(int)a1;
//                    if (b1<=a){
//                        animator5.pause();
//                    }
//                    else if (b1>a+100){
//                        animator5.resume();
//                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(),"cuowu",Toast.LENGTH_SHORT).show();
                }

            }
        }).start();
        ImageView imageView=(ImageView)findViewById(R.id.shezhi);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                    mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }
}
