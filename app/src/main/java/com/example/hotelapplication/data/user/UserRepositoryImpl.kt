package com.example.hotelapplication.data.user

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override suspend fun getUser(phone: String, email: String, password: String): User? {
        return userDao.getUser(phone, email, password)
    }
}