package com.example.testingmyentertainment.Classical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.testingmyentertainment.CourseModel;
import com.example.testingmyentertainment.Musics.Mohiner_Ghoraguli;
import com.example.testingmyentertainment.Musics.folk.Indian_folk;
import com.example.testingmyentertainment.Musics.folk.bengali_folk;
import com.example.testingmyentertainment.Musics.mohinerghoraguli;
import com.example.testingmyentertainment.R;
import com.example.testingmyentertainment.adapyer.CourseGVAdapter;
import com.example.testingmyentertainment.adapyer.DetailActivity;
import com.example.testingmyentertainment.adapyer.DetailActivity1;

import java.util.ArrayList;

public class Folk_song extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical_song);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        // First, add items to your courseModelArrayList
        courseModelArrayList.add(new CourseModel("BengaliFolk", R.drawable.bengalifolk));
        courseModelArrayList.add(new CourseModel("IndianFolk", R.drawable.indianfolk));
        courseModelArrayList.add(new CourseModel("Irish", R.drawable.irish));
        courseModelArrayList.add(new CourseModel("Scottish", R.drawable.scottish));
        courseModelArrayList.add(new CourseModel("Brazilian", R.drawable.brazilian));
        courseModelArrayList.add(new CourseModel("Mexican", R.drawable.mexican));
        int size = courseModelArrayList.size();
        int firstChunkSize = 6;
        ArrayList<CourseModel> firstList = new ArrayList<>(courseModelArrayList.subList(0, Math.min(firstChunkSize, size)));
        GridView gridView1 = findViewById(R.id.idGVcourses1);
        CourseGVAdapter adapter1 = new CourseGVAdapter(this, firstList);
        gridView1.setAdapter(adapter1);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;

                if (position == 0) {
                    intent = new Intent(Folk_song.this, bengali_folk.class);
                } else if (position == 1) {
                    intent = new Intent(Folk_song.this, Indian_folk.class);
                } else if (position == 2) {
                    intent = new Intent(Folk_song.this, bengali_folk.class);
                }else if (position == 3) {
                    intent = new Intent(Folk_song.this, DetailActivity.class);
                }else if (position == 4) {
                    intent = new Intent(Folk_song.this, DetailActivity.class);
                }else if (position == 5) {
                    intent = new Intent(Folk_song.this, Mohiner_Ghoraguli.class);
                }
                else {
                    intent = new Intent(Folk_song.this, DetailActivity1.class);
                    intent.putExtra("EXTRA_POSITION", position);
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

    }
}