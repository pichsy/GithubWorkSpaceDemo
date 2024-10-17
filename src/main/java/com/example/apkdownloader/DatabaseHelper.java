package com.example.apkdownloader;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {DownloadTask.class}, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DATABASE_NAME = "download_database";
    private static DatabaseHelper instance;

    public abstract DownloadTaskDao downloadTaskDao();

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DatabaseHelper.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
