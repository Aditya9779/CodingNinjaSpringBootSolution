package com.example.TuneIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("myPlaylist")
public class MyPlaylist implements Playlist {

    private int count = 0;

    @Autowired
    Song mySong; 

    private List<Song> hindiSongsList = new ArrayList<Song>();

    public void setMySong(Song mySong) {
        this.mySong = mySong;
    }

    @Override
    public void addSong(Song song) {
        this.count++;
        this.hindiSongsList.add(song);
    }

    @Override
    public List<Song> getPlaylistSongs() {
        return this.hindiSongsList;
    }

    @Override
    public Integer getCount() {
        return count;
    }
}