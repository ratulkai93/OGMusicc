package com.example.ogmusicc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.net.Uri;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songList;
    private ListView songView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songView=(ListView)findViewById(R.id.song_list); //to retrive listview instance
        songList= new ArrayList<Song>();

    }
    public void getSongList(){
        //to retrive info on songs
        ContentResolver musicResolver= getContentResolver();
        Uri musicUri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor= musicResolver.query(musicUri, null, null,null , null);

        if(musicCursor!=null && musicCursor.moveToFirst()){

            //get columns for title, id and artist
            int columnTitle= musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int columnID= musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int columnArtist= musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

            //Add songs to list
            do{
                String thisTitle= musicCursor.getString(columnTitle);
                long thisID= musicCursor.getLong(columnID);
                String thisArtist= musicCursor.getString(columnArtist);

                songList.add(new Song(thisID,thisTitle,thisArtist));
            }
            while(musicCursor.moveToNext());
        }
    }

}
