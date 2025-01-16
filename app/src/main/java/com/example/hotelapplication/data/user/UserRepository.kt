package com.example.hotelapplication.data.user

interface UserRepository {
    suspend fun insertUser(phone: String, email: String, password: String): Long
    suspend fun getUser(phone: String, email: String, password: String): User?
}