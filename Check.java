package com.eatx.wdj.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eatx.wdj.R;
import com.google.android.material.snackbar.Snackbar;
import com.royrodriguez.transitionbutton.TransitionButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Check extends AppCompatActivity {
    private TextView date, time, reason, checknotice;
    private final Handler handler = new Handler();
    private TimerTask updateTime;
    private String getTim;
    private Button absb, attb, latb, indb;
    long now = System.currentTimeMillis();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        absb = (Button) findViewById(R.id.absencebutton);
        attb = (Button) findViewById(R.id.attendbutton);
        latb = (Button) findViewById(R.id.latebutton);
        indb = (Button) findViewById(R.id.independentbutton);
        reason = (TextView) findViewById(R.id.reason);
        checknotice = (TextView) findViewById(R.id.checknotice);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.absencebutton:
                        time;
                        checknotice;
                        break;
                    case R.id.attendbutton:
                        time;
                        checknotice;
                        break;
                    case R.id.latebutton:
                        time;
                        reason.setText();
                        checknotice;
                        break;
                    case R.id.independentbutton:
                        time;
                        checknotice;
                        break;

                }
            }
        };
        absb.setOnClickListener(listener);
        attb.setOnClickListener(listener);
        latb.setOnClickListener(listener);
        indb.setOnClickListener(listener);

        updateTime();


    }
    public void updateTime() {
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일");
        String getDate = simpleDate.format(mDate);

        date = findViewById(R.id.date);
        date.setText(getDate);
        time = findViewById(R.id.time);
        updateTime = new TimerTask() {
            @Override
            public void run() {
                Update();
            }
        };
        Timer timer = new Timer();
        timer.schedule(updateTime, 0, 1000);
    }
    protected void Update() {
        Runnable updater = new Runnable() {
            public void run() {
                long currentTime = System.currentTimeMillis();
                Date mTime = new Date(currentTime);
                SimpleDateFormat getTime = new SimpleDateFormat("aa h시 mm분 ss초");
                getTim = getTime.format(mTime);
                time.setText(getTim);
            }
        };
        handler.post(updater);
    }

}