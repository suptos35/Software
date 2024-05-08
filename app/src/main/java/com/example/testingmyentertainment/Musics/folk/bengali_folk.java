package com.example.testingmyentertainment.Musics.folk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testingmyentertainment.Musics.Mohiner_Ghoraguli;
import com.example.testingmyentertainment.Musics.MusicPlayer;
import com.example.testingmyentertainment.Musics.PlayerActivity;
import com.example.testingmyentertainment.R;

import java.util.Arrays;

public class bengali_folk extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private ArrayAdapter<String> adapter;
    private MusicPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohinerghoraguli);

        String[] songNames = {"Akasher Rasta", "Barir Lache ArshiNagar","Ele Tumi Hrid Majhare ","Gari Cholena","Ghor Korlam Nah Re Ami","Paar Koro Vober Ghate","O Mon Guru Vaja Re","Pindare Polasher Bon","Pran ar Sohe Nah","Sona Bondhu Re Kon Doshete","Tomnar Ghore Bosot Kore Koyjona","Tomay Hrid Majhare Rakhbo","Jibon Re","Oi Prem Kore Se Jane","Manush Vojle Manush Hobo","Sob Loke Koy Lalon Ki Jath","Nodi Vora Dheu"
               };
        String[] songUrls = {
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FAsheker%20rasta.mp3?alt=media&token=99bc703d-0b85-489c-bb85-4349ce9031a8",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FBarir%20Kache%20Arshinagar%20_%20%E0%A6%AC%E0%A6%BE%E0%A7%9C%E0%A6%BF%E0%A6%B0%20%E0%A6%95%E0%A6%BE%E0%A6%9B%E0%A7%87%20%E0%A6%86%E0%A6%B0%E0%A6%B6%E0%A7%80%20%E0%A6%A8%E0%A6%97%E0%A6%B0%20_%20Saif%20Zohan%20_%20Lalon%20Geeti%20_%20Bangla%20Folk%20Song%202023.mp3?alt=media&token=b2d5373b-5b26-4ccd-af28-d6e8ae6733c5",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FEle%20Tumi%20Hrid%20Majhare.mp3?alt=media&token=f9d47a94-3416-4f30-b71f-7f828e0bf30e",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FGari%20cholena.mp3?alt=media&token=b6b8c558-18fa-490f-881d-e0d19ddf4762",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FGhor%20Korlam%20Na%20Re%20Ami.mp3?alt=media&token=4bfee0d5-b2a4-4d7f-9046-9bd445c12774",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FLalon%20Geeti%20-%20Paar%20Koro%20Bhober%20Ghate%20(Fakir%20Tuntun%20Shah).mp3?alt=media&token=ced15883-7af7-4622-b899-85cfcd5e664f",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FO%20Mon%20Guru%20Bhaja%20Re%20_%20Abbasuddin%20Sings%20Folk%20Songs%20Of%20Bengal%20_%20Abbasuddin%20Ahmed%20_%20Audio.mp3?alt=media&token=fc212f60-6eea-45d5-af01-c23ccea7c00c",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FPindare%20Polasher%20Bon%20(%20New%20Version%20)%20ft.%20Wrong%20Tuli%20Band%20_%20Jhumur%20Song%20_%20Folk%20Studio%20Bangla%202024.mp3?alt=media&token=2cdd8ed8-1f8b-42e8-9504-985157fdae4c",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FPrane%20ar%20sohena.mp3?alt=media&token=4b8b0337-bde0-490d-aea7-44358c4a832f",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FSona%20Bondhu%20Re%20Kon%20Doshete%20_%20Folk%20Songs%20Of%20Bengal%20_%20Abbasuddin%20Ahmed%20_%20Audio.mp3?alt=media&token=1e7bffba-59bd-4ac4-a0c8-d07cb78f2b06",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FTomar%20Ghore%20Boshot%20Kore%20Koy%20Jona%20_%20Borno%20Chakroborty%20_%20Bangla%20Folk%20Song%20_%20Zahid%20Ahmed%20_.mp3?alt=media&token=b9b82e99-6efc-48aa-9eff-9e8ff18d70c5",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2FTomay%20Hrid%20Majhare%20Rakhbo%20ft%20%20Anusheh%20Anadil%20%20%20Folk%20Studio%20Bangla%20Song%202018.mp3?alt=media&token=b6190ae8-7e61-4878-a0c6-e4a2619d4ba6",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2Fjibon%20re.mp3?alt=media&token=f7402988-6a03-40f3-b7c6-54b64fb61eaf",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2F%E0%A6%93%E0%A6%87%20%E0%A6%AA%E0%A7%8D%E0%A6%B0%E0%A7%87%E0%A6%AE%20%E0%A6%AF%E0%A7%87%20%E0%A6%95%E0%A6%B0%E0%A7%87%20%E0%A6%B8%E0%A7%87%20%E0%A6%9C%E0%A6%BE%E0%A6%A8%E0%A7%87%20_%20Lalon%20Shah%20__%20Coke%20studio%20Feat.%20Satyaki%20Banerjee%20%26%20Babul%20Supriyo.mp3?alt=media&token=db2ccc6e-5122-415b-b05c-ef3f91697f2c",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2F%E0%A6%AE%E0%A6%A8%E0%A6%B7%20%E0%A6%AD%E0%A6%9C%E0%A6%B2%20%E0%A6%B8%E0%A6%A8%E0%A6%B0%20%E0%A6%AE%E0%A6%A8%E0%A6%B7%20%E0%A6%B9%E0%A6%AC%20(attar%20khorak).mp3?alt=media&token=b68c9a49-e144-403e-8358-57928fde83b0",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2F%E0%A6%B8%E0%A6%AC%20%E0%A6%B2%E0%A7%8B%E0%A6%95%E0%A7%87%20%E0%A6%95%E0%A7%9F%20%E0%A6%B2%E0%A6%BE%E0%A6%B2%E0%A6%A8%20%E0%A6%95%E0%A7%80%20%E0%A6%9C%E0%A6%BE%E0%A6%A4__%E0%A6%B2%E0%A6%BE%E0%A6%B2%E0%A6%A8%20%E0%A6%97%E0%A6%BE%E0%A6%A8.mp3?alt=media&token=3b1bab0b-6227-4809-b954-588190c111e0",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/Bengali%20Folk%2F%E2%80%9CNodi%20Bhora%20Dheu%E2%80%9D%20%20%E0%A6%A8%E0%A6%A6%E0%A7%80%20%E0%A6%AD%E0%A6%B0%E0%A6%BE%20%E0%A6%A2%E0%A7%87%E0%A6%89%20_%20Paban%20Das%20Baul%20_%20Bangla%20Folk%20Dunia.mp3?alt=media&token=34fc99aa-dafd-4762-ac50-3eb57033ad7b"


        };

        musicPlayer = new MusicPlayer(songNames, songUrls);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.search_view);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_bengali_folk, R.id.item_song_title, songNames) {
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
                    Intent intent = new Intent(bengali_folk.this, PlayerActivity.class);
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
