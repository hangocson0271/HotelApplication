package com.example.hotelapplication.data.user

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE (phone LIKE :phone OR email LIKE :email) AND password LIKE :passWord LIMIT 1")
    suspend fun getUser(phone: String, email: String, passWord: String) : User?

}
