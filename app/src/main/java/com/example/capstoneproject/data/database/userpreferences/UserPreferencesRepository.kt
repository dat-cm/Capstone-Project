package com.example.capstoneproject.data.database.userpreferences
import kotlinx.coroutines.flow.Flow

class UserPreferencesRepository (private val userPreferencesDao: UserPreferencesDao) {
    suspend fun insertUserPreferences(userPreferences: UserPreferences)
        = userPreferencesDao.insertUserPreferences(userPreferences)
    suspend fun updateUserClassification(userClassification: String)
        = userPreferencesDao.updateUserClassification(userClassification)
    suspend fun updateUserFoodClassification(userFoodClassification: List<String>)
        = userPreferencesDao.updateUserFoodClassification(userFoodClassification)
    suspend fun updateUserBudget(userBudget: Double)
        = userPreferencesDao.updateUserBudget(userBudget)
    suspend fun updateAllUserPref(userPreferences: UserPreferences)
    = userPreferencesDao.updateAllUserPref(userPreferences)
    fun getAllUserPreferences(userId: Int): Flow<UserPreferences>
        = userPreferencesDao.getAllUserPreferences(userId)
}