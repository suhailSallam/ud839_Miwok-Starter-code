package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("أحمر","red",R.drawable.color_red));
        words.add(new Word( "أخضر","green",R.drawable.color_green));
        words.add(new Word("بني","brown",R.drawable.color_brown));
        words.add(new Word("رمادي","gray",R.drawable.color_gray));
        words.add(new Word("أسود","black",R.drawable.color_black));
        words.add(new Word("أبيض","white",R.drawable.color_white));
        words.add(new Word("أصفر غامق","dusty yellow",R.drawable.color_dusty_yellow));
        words.add(new Word("أصفر فاتح","mustard yellow",R.drawable.color_mustard_yellow));
        words.add(new Word("زهري","pink",R.drawable.color_pink));
        words.add(new Word("أزرق","blue",R.drawable.color_blue));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_colors,R.color.text_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}//end class ColorsActivity