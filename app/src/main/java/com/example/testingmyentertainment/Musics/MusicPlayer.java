package com.example.testingmyentertainment.Musics;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class MusicPlayer {
    private String[] songNames;
    private String[] songUrls;
    private MediaPlayer mediaPlayer;

    public MusicPlayer(String[] songNames, String[] songUrls) {
        this.songNames = songNames;
        this.songUrls = songUrls;
        this.mediaPlayer = new MediaPlayer();
        this.mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    public String getUrlForSong(String songName) {
        for (int i = 0; i < songNames.length; i++) {
            if (songNames[i].equalsIgnoreCase(songName)) {
                return songUrls[i];
            }
        }
        return null;
    }

    public void playSong(String url) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync(); // prepare async to not block main thread
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            Log.e("MusicPlayer", "Error setting data source", e);
        }
    }

    public void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
