package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.security.auth.login.LoginException;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Media Player";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates MediaPlayer and variable to store it
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.worldsend);


        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // .start method will start the song. The if else statement will display logging
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "Song is finished!", Toast.LENGTH_SHORT);
                    }
                });
                if (mediaPlayer.isPlaying()) {
                    Log.d(TAG, "onClick: Media is playing");
                } else {
                    Log.e(TAG, "onClick: MediaPlayer did not play");
                }

            }

        });

        Button pauseButton = findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if/else statement detects if the media is playing, and if so, will pause when the pause button is pressed
                // will also display logging messages if the media is paused
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Log.v(TAG, "onClick: MediaPlayer paused");

                    // if an error occurs and the media doesn't pause, will display below logging in logcat
                } else {
                    mediaPlayer.start();
                    Log.e(TAG, "onClick: Mediaplayer did not pause");

                }

            }
        });

        // Code to reset media being played
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(0);
                Log.e(TAG, "onClick: Track did not restart");
            }
        });


    }
}

