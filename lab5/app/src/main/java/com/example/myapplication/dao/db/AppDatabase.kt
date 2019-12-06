package com.example.myapplication.dao.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.dao.entity.User
import com.example.myapplication.dao.interfaces.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}