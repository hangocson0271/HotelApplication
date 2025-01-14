package com.example.hotelapplication.data.user

interface UserRepository {
    suspend fun getUser(phone: String, email: String, password: String): User?
}