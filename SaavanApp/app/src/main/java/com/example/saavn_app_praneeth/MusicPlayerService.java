package com.example.saavn_app_praneeth;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.IOException;


public class MusicPlayerService extends Service {


    public static final String CHANNEL_PLAY = "actionPlay";
    public static final String CHANNEL_PAUSE = "actionPause";
    public static final String CHANNEL_ID = "channel";
    public static Notification notification;
//    private IBinder mBinder = new MyBinder();

    private static String Song;
    private static String name;
    private static String image;


    MediaPlayer mediaPlayer = new MediaPlayer();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Song = intent.getStringExtra("Music");
        name = intent.getStringExtra("Name");
        Log.d("help", name);
        image = intent.getStringExtra("Image");

        Intent dataIntent = new Intent(getApplicationContext(), ApplicationClass.class);
        dataIntent.putExtra("song", Song);
        dataIntent.putExtra("image", image);
        dataIntent.putExtra("name", name);
        Thread thread = new Thread(play);
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

//    private void getData(Intent intent) {
//        Song=intent.getStringExtra("Music");
//        name=intent.getStringExtra("Name");
//        Log.d("help", name);
//        image=intent.getStringExtra("Image");
//
//    }


    Runnable play = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void run() {
            startMuscic();
            mediaPlayer.start();
        }
    };

    private String none = "https://audio-ssl.itunes.apple.com/itunes-assets/Music/v4/05/f9/7d/05f97d42-14b6-c2ab-151e-c873b82eb351/mzaf_1259936494542158486.plus.aac.p.m4a";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startMuscic() {

        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            if (!Song.equals(null)) {
                mediaPlayer.setDataSource(Song);
            } else
                mediaPlayer.setDataSource(none);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //    public class MyBinder extends Binder {
//
//        MusicPlayerService getService() {
//            return MusicPlayerService.this;
//        }
//    }


    public static void createNotification(Context context, int playBtn, int pos, int size) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, "tag");
            Bitmap icon = BitmapFactory.decodeResource(context.getResources(), Integer.parseInt(image));

            notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                    .setContentTitle(name)
                    .setLargeIcon(icon)
                    .setOnlyAlertOnce(true)
                    .setShowWhen(false)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();


        }


    }


}
