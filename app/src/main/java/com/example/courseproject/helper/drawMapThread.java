package com.example.courseproject.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.example.courseproject.choosetopic;

/**
 * Created by andrew on 11/4/17.
 */

public class drawMapThread extends Thread {
    Dot java;
    Dot python;
    Dot linux;
    choosetopic act;
    SurfaceHolder holder;
    Canvas canvas;
    Boolean running;
    Bitmap bg_picture;
    Paint p;

    public drawMapThread(choosetopic act, SurfaceHolder holder, int id){
        this.act = act;
        this.holder = holder;
        running = true;
        this.java = act.getJava();
        this.python = act.getPython();
        this.linux = act.getLinux();
        bg_picture = BitmapFactory.decodeResource(act.getResources(), id);
    }

    public void setRunning(boolean b) {
        running = b;
    }

    @Override
    public void run(){
        while(running) {
            try {
                canvas = holder.lockCanvas();
                synchronized (holder) {
                    p=new Paint();
                    canvas.drawBitmap(bg_picture, 0, 0, p);
                    java.draw(canvas);
                    python.draw(canvas);
                    linux.draw(canvas);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                if(canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
