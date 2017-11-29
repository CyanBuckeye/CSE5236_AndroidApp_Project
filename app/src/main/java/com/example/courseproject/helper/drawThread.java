package com.example.courseproject.helper;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.widget.TextView;

import com.example.courseproject.R;
import com.example.courseproject.fightactivity;


/**
 * Created by andrew on 11/4/17.
 */

public class drawThread extends Thread {
    fightactivity act;
    monster mon;
    fighter fig;
    SurfaceHolder holder;
    Canvas canvas;
    Boolean running = false;
    long start_time;
    long curr_time;

    public drawThread(fightactivity act, SurfaceHolder holder){
        this.act = act;
        mon = new monster(act);
        fig = new fighter(act);
        this.holder = holder;
    }

    @Override
    public void run() {
        start_time = System.currentTimeMillis();
        while (running) {
            try {
                canvas = holder.lockCanvas();
                synchronized (holder) {
                    canvas.drawBitmap(BitmapFactory.decodeResource(act.getResources(), R.drawable.background),0,0,null);
                    mon.draw(canvas);
                    fig.draw(canvas);
                }
                Thread.sleep(100);
                curr_time = System.currentTimeMillis() - start_time;
                int x = mon.get_x() - 5;
                mon.set_x(x);
                double time_elapsed = curr_time / 1000;
                TextView v = act.findViewById(R.id.time);
                v.setText(String.valueOf(time_elapsed));
                if(time_elapsed >= 50) {
                    running = false;
                    fig.setBitmap(R.drawable.zombie);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
        }

        /*
        try {
            canvas = holder.lockCanvas();
            synchronized (holder) {
                mon.draw(canvas);
                fig.draw(canvas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(canvas != null)
                holder.unlockCanvasAndPost(canvas);
        }
        */
    }

    public void setRunning(boolean b) {
        running = b;
    }
}