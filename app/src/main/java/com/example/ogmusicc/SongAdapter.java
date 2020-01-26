package com.example.ogmusicc;

import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongAdapter extends BaseAdapter{
    //baseAdapter outline
    @override
    public int getCount(){
        return songs.size();
    }
    @override
    public Object getItem(int arg0){
        return null;
    }
    @override
    public getItemId(int arg0){
        return 0;
    }
    @override
    public View getView(int arg0, View arg1, ViewGroup arg2){
        return null;
    }

    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    //use this method to map title/artist to textViews of song layout
    public SongAdapter(Context c, ArrayList<Song> theSongs){
        songs= theSongs;
        songInf= LayoutInflater.from(c);
    }

}
