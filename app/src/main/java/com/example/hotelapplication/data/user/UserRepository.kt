package com.example.hotelapplication.data.user

interface UserRepository {
    suspend fun insertUser(phone: String, email: String, password: String): Long
    suspend fun getUser(phone: String, email: String, password: String): User?
    suspend fun getUserByAccount(account: String): User?
    suspend fun updatePassword(user: User): Int
    suspend fun getUserById(userId: Int) : User?
    suspend fun updateUserData(user: User)
}