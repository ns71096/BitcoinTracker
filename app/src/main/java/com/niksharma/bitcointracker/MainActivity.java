package com.niksharma.bitcointracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    @Override
    protected void onResume()
    {
        super.onResume();
       lottie=findViewById(R.id.animation);
        lottie.setAnimation(R.raw.wolf_peek);
        //lottie.setRepeatCount(1);
        lottie.setSpeed(0.5f);
        lottie.playAnimation();

        Timer time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, Mainscreen.class);
                MainActivity.this.finish();

                startActivity(intent);
            }
        },5000);


    }


}
