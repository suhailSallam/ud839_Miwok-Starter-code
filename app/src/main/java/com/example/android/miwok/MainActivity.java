/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView_numbers, textView_family, textView_colors, textView_phrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        textView_numbers = findViewById(R.id.numbers);
        textView_numbers.setOnClickListener(v -> {openNumbersList(v);});
        textView_family = findViewById(R.id.family);
        textView_family.setOnClickListener(v -> {openFamilyList(v);});
        textView_colors = findViewById(R.id.colors);
        textView_colors.setOnClickListener(v -> {openColorsList(v);});
        textView_phrases = findViewById(R.id.phrases);
        textView_phrases.setOnClickListener(v -> {openPhrasesList(v);});
    }//end of onCreate()

    public void openNumbersList(View view){
        //TODO: Write your code here!
        Intent numbersIntent = new Intent(this, NumbersActivity.class);
        startActivity(numbersIntent);
    }//end of openNumbersList()

    public void openFamilyList(View view){
        //TODO: Write your code here!
        Intent familyIntent = new Intent(this, FamilyActivity.class);
        startActivity(familyIntent);
    }//end of openFamilyList()

    public void openColorsList(View view){
        //TODO: Write your code here!
        Intent colorsIntent = new Intent(this, ColorsActivity.class);
        startActivity(colorsIntent);
    }//end of openColorsList()

    public void openPhrasesList(View view){
        //TODO: Write your code here!
        Intent phrasesIntent = new Intent(this, PhrasesActivity.class);
        startActivity(phrasesIntent);
    }// end of openPhrasesList()
}//end class MainActivity
