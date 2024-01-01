package com.example.capstoneproject.data.database.userpreferences

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface UserPreferencesDao {
    //user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPreferences(userPreferences: UserPreferences)

    @Query("Update user_preferences Set user_classification = :userClassification")
    suspend fun updateUserClassification(userClassification: String)

    @Query("Update user_preferences Set user_food_classification = :userFoodClassification")
    suspend fun updateUserFoodClassification(userFoodClassification: List<String>)

    @Query("Update user_preferences Set user_budget = :userBudget")
    suspend fun updateUserBudget(userBudget: Double)

    @Update
    suspend fun updateAllUserPref(userPref: UserPreferences)

    @Query("Select * FROM user_preferences WHERE user_id = :userId")
    fun getAllUserPreferences(userId: Int) : Flow<UserPreferences>
}