package com.example.saavn_app_praneeth;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ApplicationClass extends Application {


    public static final String CHANNEL_PLAY = "actionPlay";
    public static final String CHANNEL_PAUSE = "actionPause";
    public static final String CHANNEL_ID = "Channel_1";
    public static final String CHANNEL_ID2 = "Channel_2";

    public static Notification notification;


    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();

    }

    private void createNotificationChannel() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel", "Praneeth", NotificationManager.IMPORTANCE_LOW);
            NotificationChannel channel2 = new NotificationChannel("channel 2", "Praneeth 2", NotificationManager.IMPORTANCE_LOW);
            channel.setDescription("channel 1");
            channel2.setDescription("channel 2");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationManager.createNotificationChannel(channel);
                    notificationManager.createNotificationChannel(channel2);

                }
            }

        }


    }
}
