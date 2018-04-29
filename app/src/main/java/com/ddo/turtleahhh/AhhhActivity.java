package com.ddo.turtleahhh;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class AhhhActivity extends AppCompatActivity {

    private long touchTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ahhh);

        View ahhh_layout = findViewById(R.id.ahhh_bg);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ahhh_1);
        mp.setLooping(true);

        final int minTouchTime = 400;

        final Toast keepToast = Toast.makeText(AhhhActivity.this, "Keep touching the screen to Ahhh!", Toast.LENGTH_SHORT);

        ahhh_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        touchTime = System.currentTimeMillis();

                        mp.start();

                        return false;

                    case MotionEvent.ACTION_UP:

                        final long currentTime = System.currentTimeMillis();

                        if (currentTime - touchTime < minTouchTime) {
                            if(keepToast.getView().isShown()) {
                                keepToast.cancel();
                            }
                            keepToast.show();
                        }

                        mp.pause();

                        return false;
                }
                return false;
            }
        });
    }
}
