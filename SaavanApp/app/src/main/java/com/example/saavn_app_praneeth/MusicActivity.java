package com.example.saavn_app_praneeth;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.saavn_app_praneeth.MusicPlayerService.CHANNEL_ID;
import static com.example.saavn_app_praneeth.MusicPlayerService.CHANNEL_PLAY;

public class MusicActivity extends AppCompatActivity implements onPlayerClicked, ServiceConnection {


    private ImageView ivPlay;
    private ImageView ivPause;
    private MediaPlayer mediaPlayer;
    private Intent intent;
    private String Song;
    private String name;
    private String image;
    private ImageView ivDisplay;
    private TextView tvSongName;
    private TextView tvArtistName;
    private ImageView ivBackground;
    private MediaSessionCompat mediaSession;
    private SeekBar seekBar;
    private TextView tvSeekbar;
    private MusicPlayerService musicPlayerService;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);
        intent = new Intent(this, MusicPlayerService.class);
//         mediaSession = new MediaSessionCompat(this,"player");
        getDataFromIntent();

        Thread thread= new Thread(run);
        thread.start();


    }


    @Override
    protected void onResume() {
        super.onResume();

//        bindService(intent,this,BIND_AUTO_CREATE);

    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        unbindService(this);
//    }

    Runnable run =new Runnable() {
        @Override
        public void run() {
            initViews();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Glide.with(ivDisplay).load(image).into(ivDisplay);
                    Glide.with(ivBackground).load(image).into(ivBackground);
                    tvSongName.setText(name);

                }
            });
        }
    };

    private void getDataFromIntent() {

        Song = getIntent().getStringExtra("Music");
        name = getIntent().getStringExtra("Name");
        image = getIntent().getStringExtra("Image");

    }

    private void initViews() {
        ivPlay = findViewById(R.id.Play);
        ivPause = findViewById(R.id.Pause);
        ivDisplay = findViewById(R.id.PlayingImage);
        ivBackground = findViewById(R.id.backgroundImage);
        tvArtistName = findViewById(R.id.ArtistName);
        tvSongName = findViewById(R.id.ArtistName);
        seekBar = findViewById(R.id.SeekBar);
        tvSeekbar = findViewById(R.id.tvSeekBar);



        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlay.setVisibility(View.INVISIBLE);
                ivPause.setVisibility(View.VISIBLE);

//                showNotification(R.drawable.ic_baseline_pause_24);

//                MusicPlayerService.createNotification(getApplicationContext(),R.drawable.ic_baseline_pause_24,1,10);



                intent.putExtra("Music", Song);
                intent.putExtra("Image", image);
                intent.putExtra("Name", name);
                startService(intent);
            }
        });

        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlay.setVisibility(View.VISIBLE);
                ivPause.setVisibility(View.INVISIBLE);
                stopService(intent);
            }
        });

    }

    @Override
    public void playClicked() {


    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

//        MusicPlayerService.MyBinder binder = (MusicPlayerService.MyBinder) service;
//        musicPlayerService = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

//        musicPlayerService= null;
    }

//
//    public  void showNotification(int playPauseButton){
//
//        Intent intent = new Intent(this, MusicActivity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(this,0,intent,0);
//
//        Intent playIntent = new Intent(this,NotificationReceiver.class).setAction(CHANNEL_PLAY);
//        PendingIntent playPendingIntent = PendingIntent.getBroadcast(this,0,playIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        Bitmap picture = BitmapFactory.decodeResource(getResources(),Integer.parseInt(image));
//
//        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_baseline_music_note_24)
//                .setLargeIcon(picture)
//                .setContentTitle(name)
//                .addAction(R.drawable.ic_baseline_play_arrow_24,"play",playPendingIntent)
//                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle().setMediaSession(mediaSession.getSessionToken()))
//                .setPriority(NotificationCompat.PRIORITY_LOW)
//                .setContentIntent(contentIntent)
//                .setOnlyAlertOnce(true)
//                .build();
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(0,notification);
//
//    }

}