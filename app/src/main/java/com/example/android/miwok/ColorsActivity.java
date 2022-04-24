package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("أحمر","red",R.drawable.color_red,R.raw.color_red));
        words.add(new Word( "أخضر","green",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("بني","brown",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("رمادي","gray",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("أسود","black",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("أبيض","white",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("أصفر غامق","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("أصفر فاتح","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("زهري","pink",R.drawable.color_pink,R.raw.color_pink));
        words.add(new Word("أزرق","blue",R.drawable.color_blue,R.raw.color_blue));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_colors,R.color.text_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }//end of onCreate()
}//end class ColorsActivity