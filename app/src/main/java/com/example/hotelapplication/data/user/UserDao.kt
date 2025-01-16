package com.example.hotelapplication.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User): Int

    @Query("SELECT * FROM user WHERE (phone LIKE :phone OR email LIKE :email) AND password LIKE :passWord LIMIT 1")
    suspend fun getUser(phone: String, email: String, passWord: String) : User?


    @Query("SELECT * FROM user WHERE (account LIKE :account OR phone LIKE :account OR email LIKE :account) LIMIT 1")
    suspend fun getUserByAccount(account: String) : User?
    @Query("SELECT * FROM user WHERE user_id LIKE :userId")
    suspend fun getUserById(userId: Int) : User?
}
