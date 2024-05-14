package com.example.testingmyentertainment.Beatles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testingmyentertainment.Musics.MusicPlayer;
import com.example.testingmyentertainment.Musics.PlayerActivity;
import com.example.testingmyentertainment.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FavoriteSongsActivity extends AppCompatActivity {

    private ListView favoritesListView;
    private ArrayAdapter<String> adapter;
    private Set<String> favoriteSongs = new HashSet<>();
    private MusicPlayer musicPlayer;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_songs);

        Intent intent = getIntent();
        String[] songNames = intent.getStringArrayExtra("songNames");
        String[] songUrls = intent.getStringArrayExtra("songUrls");

        // Initialize MusicPlayer
        musicPlayer = new MusicPlayer(songNames, songUrls);

        // Load favorites from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("Favorites", MODE_PRIVATE);
        Set<String> favoritesSet = prefs.getStringSet("FavoriteSongs", new HashSet<>());

        // Create a list of favorite song names to display
        List<String> favoriteSongList = Arrays.stream(songNames)
                .filter(favoritesSet::contains)
                .collect(Collectors.toList());

        // Set up adapter with favorite song names
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favoriteSongList);
        favoritesListView = findViewById(R.id.favoritesListView);
        favoritesListView.setAdapter(adapter);

        // Set up ListView item click listener to play songs
        favoritesListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSongName = adapter.getItem(position);
            Log.d("FavoriteSongsActivity", "Selected song: " + selectedSongName);
            if (selectedSongName != null) {
                // Find the index of the song from the songNames array
                int actualIndex = Arrays.asList(songNames).indexOf(selectedSongName);
                if (actualIndex >= 0 && actualIndex < songUrls.length) {
                    Intent intent1 = new Intent(FavoriteSongsActivity.this, PlayerActivity.class);
                    intent1.putExtra("songNames", songNames); // Pass the array of all song names
                    intent1.putExtra("songUrls", songUrls); // Pass the array of all song URLs
                    intent1.putExtra("currentIndex", actualIndex); // Pass the index of selected song
                    startActivity(intent1);
                } else {
                    Log.e("FavoriteSongsActivity", "Selected song is out of bounds: " + actualIndex);
                }
            }
        });


    }
}