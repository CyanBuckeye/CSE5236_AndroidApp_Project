package com.example.courseproject.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.courseproject.choosetopic;

/**
 * Created by andrew on 11/4/17.
 */
public class Dot{
    Bitmap icon;
    int width;
    int height;
    int x;
    int y;
    choosetopic act;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){ return width; }

    public int getHeight(){ return height; }

    public Dot(choosetopic act, int[] position, int id){
        this.act = act;
        x = position[0];
        y = position[1];
        this.icon = BitmapFactory.decodeResource(act.getResources(), id);
        this.width = icon.getWidth() / 8;
        this.height = icon.getHeight() / 8;
        Log.d("get height", Integer.toString(height));
        this.icon = Bitmap.createScaledBitmap(this.icon, this.width, this.height, false);
    }

    void draw(Canvas canvas){
        Rect src = new Rect();
        src.set(0, 0, icon.getWidth(), icon.getHeight());
        Rect dst = new Rect();
        dst.set(x, y, x + this.width, y + this.height);
        canvas.drawBitmap(this.icon, src, dst, null);
    }
}
