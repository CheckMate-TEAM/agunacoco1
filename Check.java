package com.eatx.wdj.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eatx.wdj.R;
import com.google.android.material.snackbar.Snackbar;
import com.royrodriguez.transitionbutton.TransitionButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Check extends AppCompatActivity {
    private TextView date, time, reason, checknotice, fieldturn;
    private ImageView circle, circle2;
    private TimerTask updateTime;
    private String getTim;
    private Button absb, attb, latb, indb;
    long now = System.currentTimeMillis();
    long time1 = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        time = (TextView) findViewById(R.id.time);
        fieldturn = (TextView) findViewById(R.id.fieldturn);
        circle = (ImageView) findViewById(R.id.circle);
        circle2 = (ImageView) findViewById(R.id.circle2);
        absb = (Button) findViewById(R.id.absencebutton);
        attb = (Button) findViewById(R.id.attendbutton);
        latb = (Button) findViewById(R.id.latebutton);
        indb = (Button) findViewById(R.id.independentbutton);
        reason = (TextView) findViewById(R.id.reason);
        checknotice = (TextView) findViewById(R.id.checknotice);


        View.OnClickListener listen = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.absencebutton:
                        circle.setVisibility(View.VISIBLE);
                        time.setVisibility(View.VISIBLE);
                        checknotice.setVisibility(View.VISIBLE);
                        reason.setVisibility(View.VISIBLE);
                        absb.setBackgroundColor(Color.rgb(255, 204, 51));
                        absb.setEnabled(false);
                        attb.setEnabled(false);
                        latb.setEnabled(false);
                        indb.setEnabled(false);
                        break;
                    case R.id.attendbutton:
                        circle.setVisibility(View.VISIBLE);
                        time.setVisibility(View.VISIBLE);
                        checknotice.setVisibility(View.VISIBLE);
                        attb.setBackgroundColor(Color.rgb(255, 204, 51));
                        absb.setEnabled(false);
                        attb.setEnabled(false);
                        latb.setEnabled(false);
                        indb.setEnabled(false);
                        break;
                    case R.id.latebutton:
                        circle.setVisibility(View.VISIBLE);
                        circle2.setVisibility(View.VISIBLE);
                        time.setVisibility(View.VISIBLE);
                        checknotice.setVisibility(View.VISIBLE);
                        fieldturn.setVisibility(View.VISIBLE);
                        latb.setBackgroundColor(Color.rgb(255, 204, 51));
                        absb.setEnabled(false);
                        attb.setEnabled(false);
                        latb.setEnabled(false);
                        indb.setEnabled(false);
                        break;
                    case R.id.independentbutton:
                        circle.setVisibility(View.VISIBLE);
                        circle2.setVisibility(View.VISIBLE);
                        time.setVisibility(View.VISIBLE);
                        checknotice.setVisibility(View.VISIBLE);
                        fieldturn.setVisibility(View.VISIBLE);
                        indb.setBackgroundColor(Color.rgb(255, 204, 51));
                        absb.setEnabled(false);
                        attb.setEnabled(false);
                        latb.setEnabled(false);
                        indb.setEnabled(false);
                        break;
                }
            }
        };

        absb.setOnClickListener(listen);
        attb.setOnClickListener(listen);
        latb.setOnClickListener(listen);
        indb.setOnClickListener(listen);

        updateTime();
        Update();
        updateNotice();
    }
    public void updateTime() {
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일");
        String getDate = simpleDate.format(mDate);
        date = findViewById(R.id.date);
        date.setText(getDate);

    }
    protected void Update() {
        long currentTime = System.currentTimeMillis();
        Date mTime = new Date(currentTime);
        SimpleDateFormat simpleTime = new SimpleDateFormat("aa h시 mm분");
        getTim = simpleTime.format(mTime);
        time = findViewById(R.id.time);
        time.setText(getTim);

    }
    protected void updateNotice(){
        Date mDate = new Date(now);
        SimpleDateFormat NoticeTime = new SimpleDateFormat("yyyy.MM.dd.(EE) aa h:mm 구나현님 출석하셨습니다.");
        String getTime = NoticeTime.format(mDate);
        checknotice.setText(getTime);
    }
    protected void fieldnum(){

    }
}