package com.freetime.musicplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.List;

public class Mp3Finder {

    public static class AudioFile {
        public String title;
        public String artist;
        public String path;
    }

    public static List<AudioFile> getAllMp3Files(ContentResolver contentResolver) {
        List<AudioFile> audioFiles = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0 AND " +
                MediaStore.Audio.Media.MIME_TYPE + "=?";
        String[] selectionArgs = new String[]{"audio/mpeg"};

        Cursor cursor = contentResolver.query(
                uri,
                projection,
                selection,
                selectionArgs,
                MediaStore.Audio.Media.TITLE + " ASC"
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                AudioFile file = new AudioFile();
                file.title = cursor.getString(0);
                file.artist = cursor.getString(1);
                file.path = cursor.getString(2);
                audioFiles.add(file);
            }
            cursor.close();
        }

        return audioFiles;
    }
}
