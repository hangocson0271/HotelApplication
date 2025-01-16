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

    override suspend fun getUserByAccount(account: String): User? {
        return userDao.getUserByAccount(account)
    }

    override suspend fun updatePassword(user: User): Int {
        return userDao.updateUser(user)
    }

    override suspend fun getUserById(userId: Int): User? {
        return userDao.getUserById(userId)
    }
    override suspend fun updateUserData(user: User) {
        userDao.updateUser(user)
    }
}