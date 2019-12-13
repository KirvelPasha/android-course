package com.example.myapplication.dao.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.dao.entity.User
import com.example.myapplication.dao.interfaces.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var appDatabase: AppDatabase?= null

        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "test"
                ).allowMainThreadQueries()
                    .build()
            }
            return appDatabase!!
        }

    }
}
