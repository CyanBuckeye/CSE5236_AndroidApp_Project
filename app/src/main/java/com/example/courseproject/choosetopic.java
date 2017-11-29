package com.example.courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.courseproject.helper.Dot;
import com.example.courseproject.helper.drawMapThread;

public class choosetopic extends AppCompatActivity implements SurfaceHolder.Callback{

    drawMapThread thread;
    SurfaceView v;
    SurfaceHolder holder;
    Dot java;
    Dot python;

    public Dot getJava(){
        return java;
    }

    public Dot getPython(){
        return python;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("choosetopicActivity", "choosetopic_oncreate");
        setContentView(R.layout.activity_choosetopic);
        v = findViewById(R.id.surfaceview);
        holder = v.getHolder();
        int x = getResources().getDisplayMetrics().heightPixels / 3;
        int y = getResources().getDisplayMetrics().widthPixels / 3;
        int[] Position = {x, y};
        java = new Dot(this, Position, R.drawable.java);

        x = getResources().getDisplayMetrics().heightPixels / 8;
        y = getResources().getDisplayMetrics().widthPixels / 2;
        Position[0] = x; Position[1] = y;
        python = new Dot(this, Position, R.drawable.python);
        thread = new drawMapThread(this, holder);
        thread.start();
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("choosetopicActivity", "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("choosetopicActivity", "onPause");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("choosetopicActivity", "onDestroy");
    }

    protected void onClick_goback(View view){
        Intent intent = new Intent(this, UserMainFieldActivity.class);
        startActivity(intent);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(thread == null){
            drawMapThread thread = new drawMapThread(this, holder);
            thread.setRunning(true);
            thread.start();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {}
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x = (int)event.getX();
        int y = (int)event.getY();
        y -= 289;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(x >= java.getX() && x <= java.getX() + java.getWidth() && y >= java.getY() && y <= java.getY() + java.getHeight())
                {
                    Intent intent = new Intent(this, fightactivity.class);
                    intent.putExtra("type", "1");
                    startActivity(intent);
                }
                else{
                    if(x >= python.getX() && x <= python.getX() + python.getWidth() && y >= python.getY() && y <= python.getY() + python.getHeight())
                    {
                        Intent intent = new Intent(this, fightactivity.class);
                        intent.putExtra("type", "0");
                        startActivity(intent);
                    }
                }
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }
        return false;
    }
}
