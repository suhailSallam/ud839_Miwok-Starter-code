package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    TextView arabicTextView, defaultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("أب","father"));
        words.add(new Word( "أم","mother"));
        words.add(new Word("إبن","son"));
        words.add(new Word("إبنة","daughter"));
        words.add(new Word("أخ أكبر","older brother"));
        words.add(new Word("أخ أصغر","younger brother"));
        words.add(new Word("أخت كبرى","older sister"));
        words.add(new Word("أخت صغرى","younger sister"));
        words.add(new Word("جدة","grandmother"));
        words.add(new Word("جد","grandfather"));

        arabicTextView  = findViewById(R.id.arabic_text_view);
        defaultTextView = findViewById(R.id.default_text_view);


        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.familyListView);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}