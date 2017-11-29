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

public class fighter {
    Bitmap fighter_map;
    Boolean stop;
    int width;
    int height;
    fightactivity act;
    int x;
    int y;
    LinearLayout linearLayout;

    public fighter(fightactivity act){
        this.act = act;
        this.stop = false;
        this.fighter_map = BitmapFactory.decodeResource(act.getResources(), R.drawable.fighter);
        this.width = this.fighter_map.getWidth() / 8;
        this.height = this.fighter_map.getHeight() / 8;
        this.fighter_map = Bitmap.createScaledBitmap(this.fighter_map, this.width, this.height, false);
        linearLayout = act.findViewById(R.id.view_linearout);
        x = 0;
        y = act.getResources().getDisplayMetrics().heightPixels / 5 - 2 * this.height;

    }

    public void setBitmap(int id){
        fighter_map = BitmapFactory.decodeResource(act.getResources(), id);
        this.width = this.fighter_map.getWidth() / 8;
        this.height = this.fighter_map.getHeight() / 8;
        this.fighter_map = Bitmap.createScaledBitmap(this.fighter_map, this.width, this.height, false);
        x = 0;
        y = act.getResources().getDisplayMetrics().heightPixels / 5 - 2 * this.height;
    }

    public void draw(Canvas canvas){
        Rect src = new Rect();
        src.set(0, 0, fighter_map.getWidth(), fighter_map.getHeight());
        Rect dst = new Rect();
        dst.set(x, y, x + this.width, y + this.height);
        canvas.drawBitmap(this.fighter_map, src, dst, null);
    }
}