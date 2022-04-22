package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("إلى أين أنت ذاهب؟","Where are you going?"));
        words.add(new Word( "ما هو اسمك؟","What is your name?"));
        words.add(new Word("إسمي هو ...","My name is..."));
        words.add(new Word("كيف تشعر؟","How are you feeling?"));
        words.add(new Word("أشعر بشعور جيد.","I'm feeling good."));
        words.add(new Word("هل أنت قادم؟","Are you coming?"));
        words.add(new Word("نعم، أنا قادم.","Yes, I'm coming."));
        words.add(new Word("أنا قادم.","i'm coming."));
        words.add(new Word("لنذهب.","Let's go."));
        words.add(new Word("تعال هنا.","Come here."));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_phrases,R.color.text_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}//end class PhrasesActivity