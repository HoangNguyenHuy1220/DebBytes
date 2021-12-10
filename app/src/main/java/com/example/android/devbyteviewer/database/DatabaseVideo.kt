package com.example.android.devbyteviewer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseVideo::class], version = 1, exportSchema = false)
abstract class DatabaseWhatever: RoomDatabase() {
    abstract val videoDao: VideoDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseWhatever? = null

        fun getInstance(context: Context): DatabaseWhatever {
            return INSTANCE ?: synchronized(this) {
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseWhatever::class.java,
                    "database_video"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}