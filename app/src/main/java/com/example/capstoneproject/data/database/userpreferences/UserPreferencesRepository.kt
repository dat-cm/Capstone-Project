package com.example.capstoneproject.data.database.userpreferences
import kotlinx.coroutines.flow.Flow

class UserPreferencesRepository (private val userPreferencesDao: UserPreferencesDao) {
    suspend fun insertUserPreferences(userPreferences: UserPreferences)
        = userPreferencesDao.insertUserPreferences(userPreferences)
    suspend fun deleteUserPreferences(userPreferences: UserPreferences)
        = userPreferencesDao.deleteUserPreferences(userPreferences)
    suspend fun updateUserPreferences(userPreferences: UserPreferences)
        = userPreferencesDao.updateUserPreferences(userPreferences)
    fun getAllUserPreferences(userid: Int): Flow<List<UserPreferences>>
        = userPreferencesDao.getAllUserPreferences(userid)
}