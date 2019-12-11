package com.example.myapplication.dao.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.dao.entity.User

@Dao
interface UserDao {
    @Query("SELECT id, first_name, last_name, birthday FROM user " +
            "WHERE first_name LIKE :first AND last_name LIKE :last")
    fun getByFilter(first: String, last: String): List<User>

    @Insert
    fun insert(user: User)
}