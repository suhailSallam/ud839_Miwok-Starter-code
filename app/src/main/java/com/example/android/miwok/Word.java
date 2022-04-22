package com.example.android.miwok;

public class Word {
    private String mArabicTranslation, mDefaultTranslation;

    public Word() {
    }//end pf empty constructor

    public Word(String arabicTranslation, String defaultTranslation) {
        this.mArabicTranslation = arabicTranslation;
        this.mDefaultTranslation = defaultTranslation;
    }//end of full Constructor

    public String getArabicTranslation() {
        return mArabicTranslation;
    }//end of get Arabic Translation

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }//end of get Default Translation
}//end Model class Word
