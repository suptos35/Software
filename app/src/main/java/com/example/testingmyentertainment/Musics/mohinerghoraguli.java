package com.example.testingmyentertainment.Musics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.example.testingmyentertainment.R;

import java.util.ArrayList;

public class mohinerghoraguli extends AppCompatActivity {

    private ListView listView;
    private String[] songNames = {"Ai bidaye", "Amar sohor"};
    private String[] songUrls = {
            "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Ei%20Bidaye%20__%20%E0%A6%8F%E0%A6%87%20%E0%A6%AC%E0%A6%BF%E0%A6%A6%E0%A6%BE%E0%A7%9F%E0%A7%87%20__%20Artcell%20__%20Live%20Now%20__%20Original%20Track%20__%20%40G%20Series%20World%20Music.mp3?alt=media&token=e66cd4be-8a3d-44c1-8db5-d396b2bc3881",
           "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Ekdin%20bristy%20te%20bikele%20-%20Anjan%20dutt%20_%20%E0%A6%8F%E0%A6%95%E0%A6%A6%E0%A6%BF%E0%A6%A8%20%E0%A6%AC%E0%A7%83%E0%A6%B7%E0%A7%8D%E0%A6%9F%E0%A6%BF%E0%A6%A4%E0%A7%87%20%E0%A6%AC%E0%A6%BF%E0%A6%95%E0%A7%87%E0%A6%B2%E0%A7%87%20-%20%E0%A6%85%E0%A6%9E%E0%A7%8D%E0%A6%9C%E0%A6%A8%20%E0%A6%A6%E0%A6%A4%E0%A7%8D%E0%A6%A4.mp3?alt=media&token=cfb438f6-69ea-4b09-b5fc-8a86877e932f"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohinerghoraguli);
        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(mohinerghoraguli.this, PlayerActivity.class);
            intent.putExtra("songNames", songNames);
            intent.putExtra("songUrls", songUrls);
            intent.putExtra("currentIndex", position);
            startActivity(intent);
        });
    }
}