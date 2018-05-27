package com.example.asdf.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button video;
    Button audio;

    public static String DATA_SOURCE = "com.example.asdf.lab4.DATA_SOURCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio = findViewById(R.id.btnAudio);
        video = findViewById(R.id.btnVideo);

        audio.setOnClickListener(this);
        video.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.btnAudio:
                intent = new Intent(this, AudioFileActivity.class);
                intent.putExtra(DATA_SOURCE, R.raw.totoafrica);
                startActivity(intent);
                break;
            case R.id.btnVideo:
                intent = new Intent(this, VideoFileActivity.class);
                intent.putExtra(DATA_SOURCE, R.raw.totoafricavideo);
                startActivity(intent);
                break;
        }
    }
}
