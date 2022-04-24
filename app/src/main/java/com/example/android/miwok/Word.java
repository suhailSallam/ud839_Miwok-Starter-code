package com.example.android.miwok;

public class Word {
    // Arabic translation class variable, Default translation class variable
    private String mArabicTranslation   , mDefaultTranslation;

    //Arabic Sound file for the word
    private int  mSoundFileId;

    //Image resource ID for the word
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    //constructor with 3 params only
    public Word(String arabicTranslation, String defaultTranslation, int soundFileId) {
        this.mArabicTranslation = arabicTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mSoundFileId = soundFileId;
    }//end of 3 para Constructor

    //Constructor with 4 params only
    public Word(String arabicTranslation, String defaultTranslation, int imageResourceID, int soundFileId) {
        this.mArabicTranslation = arabicTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mImageResourceID = imageResourceID;
        this.mSoundFileId = soundFileId;
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

    public int getSoundFileId() {
        return mSoundFileId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public boolean hasImage() {
         return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}//end Model class Word
