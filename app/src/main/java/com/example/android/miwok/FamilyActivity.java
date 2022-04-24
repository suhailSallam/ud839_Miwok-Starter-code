package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("أب","father",R.drawable.family_father,R.raw.family_father));
        words.add(new Word( "أم","mother",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("إبن","son",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("إبنة","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("أخ أكبر","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("أخ أصغر","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("أخت كبرى","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("أخت صغرى","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("جدة","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("جد","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_family,R.color.text_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}//end class FamilyActivity