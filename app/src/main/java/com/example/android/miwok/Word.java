package com.example.android.miwok;

public class Word {
    // Arabic translation class variable, Default translation class variable
    private String mArabicTranslation   , mDefaultTranslation;
    //Image resource ID for the word
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    public Word(String arabicTranslation, String defaultTranslation) {
        this.mArabicTranslation = arabicTranslation;
        this.mDefaultTranslation = defaultTranslation;
    }//end of 2 para Constructor
    public Word(String arabicTranslation, String defaultTranslation, int imageResourceID) {
        this.mArabicTranslation = arabicTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mImageResourceID = imageResourceID;
    }//end of full Constructor

    public String getArabicTranslation() {
        return mArabicTranslation;
    }//end of get Arabic Translation

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }//end of get Default Translation

    public int getImageResourceID() {
        return mImageResourceID;
    }

    /**
     * Return the image resource ID of the word.
     */
    public boolean hasImage() {
         return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}//end Model class Word
