package com.ddo.turtleahhh;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;

public class AhhhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahhh);

        View ahhh_layout = findViewById(R.id.ahhh_bg);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ahhh_1);
        mp.setLooping(true);

        ahhh_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("DDO", "DOWN");
                        mp.start();
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.d("DDO", "UP");
                        //mp.stop();
                        mp.pause();
                        return true;
                }
                return false;
            }
        });
    }
}
