package com.example.testingmyentertainment.Musics;

public class MusicPlayer {
    private String[] songNames;
    private String[] songUrls;

    public MusicPlayer(String[] songNames, String[] songUrls) {
        this.songNames = songNames;
        this.songUrls = songUrls;
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
        // Logic to play the song
        System.out.println("Playing song at URL: " + url);
    }
}

