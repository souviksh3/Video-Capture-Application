package com.example.demo_video_capture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button mbtn;
    VideoView mvdo;
    public static  final int camera_code=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn = findViewById(R.id.btn);
        mvdo = findViewById(R.id.vdo);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent,camera_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==camera_code && resultCode== Activity.RESULT_OK){
            Uri um = data.getData();
            mvdo.setVideoURI(um);
            mvdo.setMediaController(new MediaController(this));
        } else{

        Toast.makeText(this,"Image Canceled",Toast.LENGTH_LONG);
    }
    }
}
