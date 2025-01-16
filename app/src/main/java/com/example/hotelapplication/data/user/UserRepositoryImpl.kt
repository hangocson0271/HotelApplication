package com.example.hotelapplication.data.user

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override suspend fun insertUser(phone: String, email: String, password: String): Long {
        return userDao.insertUser(
            User(
                user_name = phone,
                phone = phone,
                email = email,
                password = password
            )
        )
    }

    override suspend fun getUser(phone: String, email: String, password: String): User? {
        return userDao.getUser(phone, email, password)
    }
}