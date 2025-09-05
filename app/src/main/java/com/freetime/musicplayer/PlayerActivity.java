package com.freetime.musicplayer;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.common.MediaItem;

public class PlayerActivity extends AppCompatActivity {

    private ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Player-Instanz erstellen
        player = new ExoPlayer.Builder(this).build();

        // Lokale Datei laden (Pfad anpassen)
        Uri audioUri = Uri.parse("file:///sdcard/Music/song.mp3");
        MediaItem mediaItem = MediaItem.fromUri(audioUri);

        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
