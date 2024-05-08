package com.example.testingmyentertainment.Musics.folk;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.example.testingmyentertainment.Musics.MusicPlayer;
import com.example.testingmyentertainment.Musics.PlayerActivity;
import com.example.testingmyentertainment.R;

import java.util.Arrays;

public class Indian_folk extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private ArrayAdapter<String> adapter;
    private MusicPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohinerghoraguli);

        String[] songNames = {
                "Resham Firiri",  "Chhap Tilak Sab Chheeni", "Nimbooda Nimbooda", "Dama Dam Mast Qalandar", "Laung Gawacha", "Banna Re Baga Mein Jhula",  "Mehndi Hai Rachnewali", "Babuji Dheere Chalna", "Nayi Heile Saruni Bahi",  "Damru Wale Baba", "Bhavageethe", "Dhola Re Dhola", "Khwaja Mere Khwaja", "Laal Meri Pat",  "Jhanjhariya", "Hori Khelan Ka"

        };
        String[] songUrls = {
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FResham%20firiri%20original%20song.mp3?alt=media&token=7ecb76f9-6215-43a6-8102-f6f1ccd8265f",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FOriginal%20Nimbooda%20Nimbooda%20Folk%20Song.Hum%20Dil%20De%20Chuke%20Sanam%20took%20Rajasthani%20Lok%20Geet.Nimbuda.Nibuda.mp3?alt=media&token=efe12f19-782f-4d1d-92c6-ff4b86cd9f49",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FMera%20Laung%20Gawacha%20by%20Musarrat%20Nazir.mp3?alt=media&token=52be3cfe-26af-4a93-81e2-78faa3226ed7",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FJhanjhariya%20-%20Male%20%20Krishna%20%20Karisma%20Kapoor%20%20Sunil%20Shetty%20%20Abhijeet%20Bhattacharya%2090's%20Hit%20Songs.mp3?alt=media&token=390b6152-85d1-4c37-b876-3117038b294b",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FDhola%20Re%20Dhola%20Devdas%20movie%20song%20full%20hd%201080p.mp3?alt=media&token=16d0419a-53d8-480a-8816-6c732aefaa3c",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FDamru%20Wale%20Baba%20Tumko%20Aana%20Hoga%20%20Sawan%20%E0%A4%95%20%E0%A4%B8%E0%A4%AA%E0%A4%B0%20Shiv%20Bhajan%20By%20Saurabh-Madhukar%20%20LYRICAL%20VIDEO.mp3?alt=media&token=0be8c657-ca57-4186-a487-91c0802bf7c9",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FDama%20Dam%20Mast%20Qalandar%20%20COKE%20STUDIO%20%20Sufi%20Qawwali.mp3?alt=media&token=3a167e60-2dfd-4c8a-9567-fe19df47c252",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FCoke%20Studio%20Season%2010%20Laal%20Meri%20Pat%20Quratulain%20Balouch%20ft.%20Akbar%20Ali%20%26%20Arieb%20Azhar.mp3?alt=media&token=c82139f4-95f2-46d5-b84d-a93287bc9ac0","" +
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FChaap%20Tilak.mp3?alt=media&token=60c67aed-2dd1-4acb-a8a1-84b96126f367",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FBanna%20Re%20Baga%20Mein.mp3?alt=media&token=bda361f6-4c72-4322-b07c-7916ccb3d863",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FBabuji%20Dheere%20Chalna%20(HD)%20-%20Aar%20Paar%20Song%20-%20Geeta%20Dutt%20-%20Guru%20Dutt%20-%20Old%20Hindi%20Song%20-%20Filmigaane.mp3?alt=media&token=1dba63c8-707c-4044-a211-a974613ff794",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FAmma%20Ninna%20EdeyaaLadalli%20(Lyrical%20Video)%20%20Bhaavageethe%20%20Just%20Vocals%20%20Shalini%20S%20R.mp3?alt=media&token=fea6cf89-7c15-45bc-9627-944d6a6ad056",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Indianfolk%2FA.R.%20Rahman%20-%20Mehendi%20Hai%20Rachnewali%20Best%20VideoZubeidaaKarisma%20KapoorAlka%20Yagnik.mp3?alt=media&token=c6751830-831a-42fb-89fe-a899b9b378cc"
        };

        musicPlayer = new MusicPlayer(songNames, songUrls);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.search_view);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_indian_folk, R.id.item_song_title, songNames) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                // Additional customization can be done here, if needed
                return view;
            }
        };
        listView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = adapter.getItem(position); // Get the item from the adapter, not directly from array
            if (selectedItem != null) {
                int actualIndex = Arrays.asList(songNames).indexOf(selectedItem);
                if (actualIndex >= 0 && actualIndex < songUrls.length) {
                    Intent intent = new Intent(Indian_folk.this, PlayerActivity.class);
                    intent.putExtra("songNames", songNames);
                    intent.putExtra("songUrls", songUrls);
                    intent.putExtra("currentIndex", actualIndex);
                    startActivity(intent);
                } else {
                    Log.e("Mohiner_Ghoraguli", "Selected position is out of bounds: " + actualIndex);
                }
            }
        });


    }
}
