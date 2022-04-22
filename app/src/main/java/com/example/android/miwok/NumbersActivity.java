package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    TextView arabicTextView, defaultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("واحد","one"));
        words.add(new Word( "اثنين","two"));
        words.add(new Word("ثلاثة","three"));
        words.add(new Word("أربعة","four"));
        words.add(new Word("خمسة","five"));
        words.add(new Word("ستة","six"));
        words.add(new Word("سبعة","seven"));
        words.add(new Word("ثمانية","eight"));
        words.add(new Word("تسعة","nine"));
        words.add(new Word("عشرة","ten"));

        arabicTextView  = findViewById(R.id.arabic_text_view);
        defaultTextView = findViewById(R.id.default_text_view);


        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.numbersListView);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}//end class NumbersActivity