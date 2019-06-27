package com.example.programamagia;

import android.app.slice.SliceMetrics;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Intro extends AppCompatActivity {

    private ImageButton porta_esq, porta_dir;
    private Timer mTimer1;
    private TimerTask mTt1;
    private Handler mTimerHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        porta_esq = (ImageButton) findViewById(R.id.imageButton_porta_esq);
        porta_dir = (ImageButton) findViewById(R.id.imageButton_porta_dir);
        porta_esq.setX(porta_esq.getX());
        porta_dir.setX(porta_dir.getX());

        porta_esq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a= porta_esq.getX()+porta_esq.getWidth();
                startTimer(a);
            }
        });

        porta_dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a= porta_dir.getX()+porta_dir.getWidth();
                startTimer(a);
            }
        });


    }

    private void stopTimer(){
        if(mTimer1 != null){
            mTimer1.cancel();
            mTimer1.purge();
        }
    }

    private void startTimer(final float val_limite){
        mTimer1 = new Timer();
        mTt1 = new TimerTask() {
            public void run() {
                mTimerHandler.post(new Runnable() {
                    public void run(){
                        porta_dir.setX(porta_dir.getX() - 1);
                        porta_esq.setX(porta_esq.getX() + 1);
                        if (porta_esq.getX()>val_limite){
                            Intent atv_open;
                            atv_open = new Intent(Intro.this, MainActivity.class);
                            startActivity(atv_open);
                            stopTimer();

                        }
                    }
                });
            }
        };

        mTimer1.schedule(mTt1, 1, 3);
    }
}
