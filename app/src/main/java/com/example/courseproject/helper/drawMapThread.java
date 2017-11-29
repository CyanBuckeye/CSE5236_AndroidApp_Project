package com.example.courseproject.helper;

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
    choosetopic act;
    SurfaceHolder holder;
    Canvas canvas;
    Boolean running;
    Paint paint;

    public drawMapThread(choosetopic act, SurfaceHolder holder){
        this.act = act;
        this.holder = holder;
        running = true;
        this.java = act.getJava();
        this.python = act.getPython();

        paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth((float)15);
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
                    java.draw(canvas);
                    python.draw(canvas);
                    canvas.drawLine(java.getX() + java.width, java.getY() + java.height, python.getX(), python.getY(), paint);
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
