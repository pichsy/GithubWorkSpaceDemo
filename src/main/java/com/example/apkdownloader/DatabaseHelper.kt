package com.example.apkdownloader

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DownloadTask::class], version = 1)
abstract class DatabaseHelper : RoomDatabase() {
    abstract fun downloadTaskDao(): DownloadTaskDao

    companion object {
        private const val DATABASE_NAME = "download_database"
        @Volatile
        private var instance: DatabaseHelper? = null

        fun getInstance(context: Context): DatabaseHelper {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseHelper::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration().build().also { instance = it }
            }
        }
    }
}
