package com.example.capstoneproject.data.database.user
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao: UserDao) {
    suspend fun insertUser(user: User)
        = userDao.insertUser(user)
    suspend fun deleteUser(user: User)
        = userDao.deleteUser(user)
    suspend fun updateUser(user: User)
        = userDao.updateUser(user)
    fun getAllUser(): Flow<List<User>>
        = userDao.getAllUser()
    fun getSpecificUser(username: String): Flow<User> =
        userDao.getSpecificUser(username)

}