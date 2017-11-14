package com.example.administrator.shapanche;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {
    private List<Point>mPointList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView timeText;
        TextView xText;
        TextView yText;
        public ViewHolder(View view){
            super(view);
            timeText=(TextView)view.findViewById(R.id.time_text);
            xText=(TextView)view.findViewById(R.id.x_text);
            yText=(TextView)view.findViewById(R.id.y_text);
        }
    }
    public PointAdapter(List<Point>pointList){
        mPointList=pointList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Point point=mPointList.get(position);
        holder.timeText.setText(point.getTime());
        holder.xText.setText(point.getX());
        holder.yText.setText(point.getY());
    }
    @Override
    public int getItemCount(){
        return mPointList.size();
    }
}
