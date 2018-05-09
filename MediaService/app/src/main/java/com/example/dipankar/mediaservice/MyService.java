package com.example.dipankar.mediaservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent){
    // Binds service with activity
    return null; // not binding hte service
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //START SERVICE OnStart is called, play the music;
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        // object player = mediaPlayer.create(this, default ringtone, settings.System.DEFAULT_RINGTONE_URI
        player.setLooping(true); // keep playign the default ringtone
        player.start(); // object start
        //TO MEDIA TO PLAY EVEN WHEN APPLICATION IN BACKGROUND WE NEED SERVICES
        //super.onStartCommand(intent, flags, startId);
        return START_STICKY;
        //service will be explicitly started
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
