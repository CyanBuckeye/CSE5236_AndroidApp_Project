package com.example.courseproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.courseproject.helper.QuestionDB;
import com.example.courseproject.helper.drawThread;

import java.util.List;

public class fightactivity extends AppCompatActivity implements SurfaceHolder.Callback{
    SurfaceView v;
    SurfaceHolder holder;
    drawThread thread;
    RadioGroup group;
    TextView scoreview;
    int type;
    int curr_idx;
    int curr_key;
    int score;
    int thresh;
    QuestionDB db;
    List<Integer> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fightactivity);
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        curr_idx = 0;
        thresh = 2;
        score = 0;

        v = findViewById(R.id.surfv);
        holder = v.getHolder();
        LinearLayout q_layout = findViewById(R.id.question_layout);

        db = new QuestionDB(type);
        li = db.getIndex();
        update_question();
        if(thread == null){
            drawThread thread = new drawThread(this, holder);
            thread.setRunning(true);
            thread.start();
        }
    }

    private  void update_question(){
        curr_key = db.getAnswer(li.get(curr_idx));
        String[] choice = db.getChoices(li.get(curr_idx));
        group = findViewById(R.id.rgroup);
        for(int i = 0 ; i < 4 ; i++){
            RadioButton radio = new RadioButton(this);
            if(i == 0) radio = findViewById(R.id.first);
            if(i == 1) radio = findViewById(R.id.second);
            if(i == 2) radio = findViewById(R.id.third);
            if(i == 3) radio = findViewById(R.id.forth);
            radio.setText(choice[i]);
        }
        TextView tv = findViewById(R.id.question_text);
        tv.setText(db.getQuestion(li.get(curr_idx)));
    }

    public void OnClick(View view){
        int selected = group.getCheckedRadioButtonId();
        if(selected == curr_key) {
            score++;
            //    scoreview.setText("score: " + Integer.toString(score));
        }
        if(score == thresh)
            judge(true);
        if(curr_idx < 3){
            curr_idx++;
            update_question();
        }
        else judge(false);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(thread == null){
            drawThread thread = new drawThread(this, holder);
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

    private void judge(Boolean input){
        TextView temp_v = findViewById(R.id.time);
        String info = (String)temp_v.getText();
        Log.d("read time", (String)temp_v.getText());
        if(input == true){
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.win)
                    .setTitle("win")
                    .setPositiveButton("ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    finish();
                                }
                            }).create()
                    .show();
        }
        else{
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.lose)
                    .setTitle("lose")
                    .setPositiveButton("ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    finish();
                                }
                            }).create()
                    .show();
        }
    }
}
