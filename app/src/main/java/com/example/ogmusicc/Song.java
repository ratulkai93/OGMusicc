package com.example.ogmusicc;

public class Song {

    private long id;
    private String title;
    private String artist;

    public Song(long songID, String songTitle, String songArtist){
        id= songID;
        title= songTitle;
        artist= songArtist;
    }
   //song info getters, can be expanded w/ supplemental info
    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist() {
        return artist;
    }

}
