package com.example.testingmyentertainment.Musics;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.example.testingmyentertainment.R;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerActivity extends AppCompatActivity {

    private JcPlayerView jcPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jc_player_view);

        jcPlayerView = findViewById(R.id.jcplayer);
        String[] songUrls = getIntent().getStringArrayExtra("songUrls");
        String[] songNames = getIntent().getStringArrayExtra("songNames");
        int currentIndex = getIntent().getIntExtra("currentIndex", -1);

        if (currentIndex >= 0 && currentIndex < songUrls.length) {
            ArrayList<JcAudio> jcAudios = new ArrayList<>();
            for (int i = 0; i < songUrls.length; i++) {
                jcAudios.add(JcAudio.createFromURL(songNames[i], songUrls[i]));
            }
            jcPlayerView.initPlaylist(jcAudios, null);
            jcPlayerView.playAudio(jcAudios.get(currentIndex));
            jcPlayerView.createNotification();
        } else {
            Log.e("PlayerActivity", "Invalid index: " + currentIndex);
            finish();  // Close the activity as the index is invalid
        }
    }
}
