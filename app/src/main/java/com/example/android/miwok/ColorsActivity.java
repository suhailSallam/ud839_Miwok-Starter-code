package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    TextView arabicTextView, defaultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("أحمر","red"));
        words.add(new Word( "أخضر","green"));
        words.add(new Word("بني","brown"));
        words.add(new Word("رمادي","gray"));
        words.add(new Word("أسود","black"));
        words.add(new Word("أبيض","white"));
        words.add(new Word("أصفر فاتح","dusty yellow"));
        words.add(new Word("أصفر غامق","mustard yellow"));
        words.add(new Word("زهري","pink"));
        words.add(new Word("أزرق","blue"));

        arabicTextView  = findViewById(R.id.arabic_text_view);
        defaultTextView = findViewById(R.id.default_text_view);


        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.colorsListView);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}