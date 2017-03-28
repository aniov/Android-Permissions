package com.aniov.android.myapplication;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHelloWordClick(View view) {
        testExplicitIntent();
        //testInternetPlayer();
    }

    private void testInternetPlayer() {
        try {
            String url = "http://sorradio.org:5005/live";
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            Toast.makeText(this, "Something went wrong sry", Toast.LENGTH_SHORT).show();
            System.out.println("Something went wrong:\n" + e);
        }
    }

    private void testExplicitIntent() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
