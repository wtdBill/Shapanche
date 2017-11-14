package com.example.administrator.shapanche;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/8/16.
 */

public class Point extends DataSupport{
    private int x;
    private int y;
    private String time;
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getTime(){
        return time;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setTime(String time){
        this.time=time;
    }
}
