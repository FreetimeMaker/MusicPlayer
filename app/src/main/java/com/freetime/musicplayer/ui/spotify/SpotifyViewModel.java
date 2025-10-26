package com.freetime.musicplayer.ui.spotify;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpotifyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SpotifyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Library fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}