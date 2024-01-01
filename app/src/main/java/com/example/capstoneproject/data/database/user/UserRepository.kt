package com.example.capstoneproject.data.database.user
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao: UserDao) {
    suspend fun insertUser(user: User)
        = userDao.insertUser(user)
    suspend fun deleteUserById(userId: Int)
        = userDao.deleteUserById(userId)
    suspend fun updateUserPref(pref: Boolean)
        = userDao.updateUserPref(pref)
    suspend fun updateUserName(userName: String)
        = userDao.updateUserName(userName)
    fun getAllUser(): Flow<List<User>>
        = userDao.getAllUser()
    fun getSpecificUser(userId: Int): Flow<User> =
        userDao.getSpecificUser(userId)
}