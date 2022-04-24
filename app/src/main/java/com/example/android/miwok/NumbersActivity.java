package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("واحد","one",R.drawable.number_one,R.raw.number_one));
        words.add(new Word( "اثنين","two",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("ثلاثة","three",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("أربعة","four",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("خمسة","five",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("ستة","six",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("سبعة","seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("ثمانية","eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("تسعة","nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("عشرة","ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_numbers,R.color.text_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }//end of onCreate()
}//end class NumbersActivity