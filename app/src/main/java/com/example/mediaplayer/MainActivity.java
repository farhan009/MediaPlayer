package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton playButton, pauseButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton_id);
        pauseButton = findViewById(R.id.pauseButton_id);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.desi_vs_videsi_mashup);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.playButton_id){
            if (playButton != null){
                mediaPlayer.start();
                int duration = mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this, "Song Played "+duration, Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.pauseButton_id){
            if (pauseButton != null){
                mediaPlayer.stop();
                Toast.makeText(MainActivity.this, "Song Paused", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
