package com.example.hotelapplication.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user WHERE (phone LIKE :phone OR email LIKE :email) AND password LIKE :passWord LIMIT 1")
    suspend fun getUser(phone: String, email: String, passWord: String) : User?

    @Query("SELECT * FROM user WHERE user_id = :userId LIMIT 1")
    suspend fun getUserById(userId: Int): User?
}
