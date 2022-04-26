package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private int length;
    private MediaPlayer.OnCompletionListener mCompletionListener = (mp -> {
        releaseMediaPlayer();
    });
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("إلى أين أنت ذاهب؟","Where are you going?",R.raw.phrase_where_are_you_going));
        words.add(new Word( "ما هو اسمك؟","What is your name?",R.raw.phrase_what_is_your_name));
        words.add(new Word("إسمي هو ...","My name is...",R.raw.phrase_my_name_is));
        words.add(new Word("كيف تشعر؟","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("أشعر بشعور جيد.","I'm feeling good.",R.raw.phrase_im_feeling_good));
        words.add(new Word("هل أنت قادم؟","Are you coming?",R.raw.phrase_are_you_coming));
        words.add(new Word("نعم، أنا قادم.","Yes, I'm coming.",R.raw.phrase_yes_im_coming));
        words.add(new Word("أنا قادم.","i'm coming.",R.raw.phrase_im_coming));
        words.add(new Word("لنذهب.","Let's go.",R.raw.phrase_lets_go));
        words.add(new Word("تعال هنا.","Come here.",R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_phrases,R.color.text_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(wordAdapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getSoundFileId());
                // Start the audio file

                // Start the audio file
                startPlayback();

                //Setup a listener on the media player, so that we can stop and release the
                //media player once the sounds has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
        audioFocusChangeListener = focusChange -> {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                pausePlayback();
                //Pause Playback
                // because your audio focus was temporarily stolen,
                //but will be back soon. i.e., like for a phone call.
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                stopPlayback();
                //Stop playback,
                //because you lost the audio focus, i.e., the user started
                //some other playback app.
                //Remember to unregister your controls/buttons here and
                //release the kra - audio focus.
                //You're done.
                mAudioManager.abandonAudioFocus(audioFocusChangeListener);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                lowerVolume();
                //Lower the volume,
                //because something else is also playing audio over you.
                //i.e., for notification or navigation directions.
                //Depending on your audio playback, you may prefer to
                //pause playback here instead.
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                resumePlayback()
                ;                //Resume playback,
                //again!
                //i.e., the phone call ended or the nav directions are finished
                //If you implement ducking and lowe the volume, be sure to return
                //it to normal here, as wll
            }//end if
        }; //end of audioFocusChangeListener = focusChange
    }//end of onCreate()


    // startPlayback() method
    private void startPlayback(){
        mMediaPlayer.start();
        //  Clean up the MediaPlayer object
        mMediaPlayer.setOnCompletionListener(mp -> {
            releaseMediaPlayer();
        });  // onCompletion() method of the onCompletionListener interface
    }//end of startPlayback()

    //pausePlayback() method
    private void pausePlayback() {
        // Pause playback
        mMediaPlayer.pause();
        length = mMediaPlayer.getCurrentPosition();
    }//end of pausePlayback()

    //resumePlayback() method
    private void resumePlayback(){
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo(length);
            mMediaPlayer.start();
        }//end if
    }//end of resumePlayback()

    //exitPlayback() method
    private void stopPlayback(){
        mMediaPlayer.stop();
        releaseMediaPlayer();
    }//end of exitPlayback()

    //lowerVolume() method
    private void lowerVolume(){
        // ADJUST_LOWER = Lowers the volume, FLAG_PLAY_SOUND = make a sound when clicked
        mAudioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
    }//end of lowerVolume()

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }//end if
    }//end releaseMediaPlayer()

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }//end of onStop()
}//end class PhrasesActivity