package com.example.courseproject.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.LinearLayout;

import com.example.courseproject.fightactivity;
import com.example.courseproject.R;
/**
 * Created by andrew on 11/4/17.
 */

public class monster{
    Bitmap monster_map;
    Boolean stop;
    int width;
    int height;
    fightactivity act;
    int x;
    int y;
    LinearLayout linearLayout;

    public monster(fightactivity act){
        this.act = act;
        this.stop = false;
        this.monster_map = BitmapFactory.decodeResource(act.getResources(), R.drawable.monster);
        this.width = this.monster_map.getWidth() / 8;
        this.height = this.monster_map.getHeight() / 8;
        this.monster_map = Bitmap.createScaledBitmap(this.monster_map, this.width, this.height, false);
        linearLayout = act.findViewById(R.id.view_linearout);
        x = act.getResources().getDisplayMetrics().widthPixels - this.width;
        y = act.getResources().getDisplayMetrics().heightPixels / 5 - 2 * this.height;

    }

    public int get_x(){
        return x;
    }

    public int get_y(){
        return y;
    }

    public void set_x(int x){
        this.x = x;
    }

    public void set_y(int y){
        this.y = y;
    }

    public void draw(Canvas canvas){
        Rect src = new Rect();
        src.set(0, 0, monster_map.getWidth(), monster_map.getHeight());
        Rect dst = new Rect();
        dst.set(x, y, x + this.width, y + this.height);
        canvas.drawBitmap(this.monster_map, src, dst, null);
    }
}
