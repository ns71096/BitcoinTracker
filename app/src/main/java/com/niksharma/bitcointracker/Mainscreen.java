package com.niksharma.bitcointracker;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Mainscreen extends AppCompatActivity {
    private TextView text1,text2,text3,text4;
    private ProgressBar progress;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_screen);

        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);
        progress=findViewById(R.id.progress);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskScheduler task=new TaskScheduler(progress,button,text1,text2,text3,text4,Mainscreen.this);
                task.execute();
            }
        });



    }

}
