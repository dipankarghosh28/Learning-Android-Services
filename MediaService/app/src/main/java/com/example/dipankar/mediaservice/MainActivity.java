package com.example.dipankar.mediaservice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        // object player = mediaPlayer.create(this, default ringtone, settings.System.DEFAULT_RINGTONE_URI
        player.setLooping(true); // keep playign the default ringtone
        player.start(); // object start
        //TO MEDIA TO PLAY EVEN WHEN APPLICATION IN BACKGROUND WE NEED SERVICES
       */
        start = (Button) findViewById(R.id.buttonstart);
        stop = (Button) findViewById(R.id.buttonstop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == start) {
            startService(new Intent(this, MyService.class));
        } else if (v == stop) {
            stopService(new Intent(this, MyService.class));
        }
    }
}
