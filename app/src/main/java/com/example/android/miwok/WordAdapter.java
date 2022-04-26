package com.example.android.miwok;

import static android.media.AudioAttributes.*;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    public MediaPlayer mediaPlayer;
    public AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener;
    /** Resource ID for the background color for this list of words */
    private int mColorResourceId, mColorTextId, mSoundFileId;

    public WordAdapter(@NonNull Context context, @NonNull List<Word> words, int colorResourceId, int colorTextId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
        mColorTextId = colorTextId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the arabic_text_view
        TextView arabicTextView = (TextView) listItemView.findViewById(R.id.arabic_text_view);

        // Get the arabic translation from the current words object and
        // set this text on the name TextView
        arabicTextView.setText(currentWord.getArabicTranslation());

        // Find the TextView in the list_item.xml layout with the default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current words object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            imageView.setImageResource(currentWord.getImageResourceID());

            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        // Find the play TextView in the list_item.xml layout so as to show same foreground
        // and background color
//        TextView play_Text_View = (TextView) listItemView.findViewById(R.id.play_text_view); to be deleted

        // Set the theme color for the list item
        View textContainer  = listItemView.findViewById(R.id.text_container);
        View textContainer1 = listItemView.findViewById(R.id.text_container1);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        int arabic_text_view_color = ContextCompat.getColor(getContext(),mColorTextId);
        int default_text_view_color = ContextCompat.getColor(getContext(),mColorTextId);
        int play_text_view_color = ContextCompat.getColor(getContext(),mColorTextId);


        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        textContainer1.setBackgroundColor(color);
        arabicTextView.setTextColor(arabic_text_view_color);
        defaultTextView.setTextColor(default_text_view_color);
//        play_Text_View.setTextColor(play_text_view_color); to be deleted


//        listItemView.setOnClickListener(v -> {
//            requestMediaPlayer();
//            mediaPlayer = MediaPlayer.create(getContext(), currentWord.getSoundFileId());
//            mediaPlayer.start();
//            // Abandon audio focus when playback complete
//            mAudioManager.abandonAudioFocus(afChangeListener);
//            //  Clean up the MediaPlayer object
//            mediaPlayer.setOnCompletionListener(mp -> releaseMediaPlayer());
//        });

//        afChangeListener = focusChange -> {
//            if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
//                // Pause playback
//                mediaPlayer.pause();
//             }
//             else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
//             {
//                // Resume playback
//                 mediaPlayer.start();
//             }
//            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
//            {
////                mAudioManager.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
//                mAudioManager.abandonAudioFocus(afChangeListener);
//                // Stop playback
//                mediaPlayer.stop();
//            }
//        };

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }//end getView()

//    //Request Audio Focus
//    private void requestMediaPlayer(){
//        releaseMediaPlayer();
//        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
//        // Request audio focus for playback
//        int result = mAudioManager.requestAudioFocus(afChangeListener,
//                // Use the music stream.
//                AudioManager.STREAM_MUSIC,
//                // Request permanent focus.
//                AudioManager.AUDIOFOCUS_GAIN);
//
//        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
////            mAudioManager.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
//            // Start playback.
//        }
//
//    }//end of requestMediaPlayer()

//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mediaPlayer.release();
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mediaPlayer = null;
//        }//end if
//    }//end releaseMediaPlayer()
}//end WordAdapter
