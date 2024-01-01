package com.example.capstoneproject.data.database.userpreferences

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

    @Delete
    suspend fun deleteUserPreferences(userPreferences: UserPreferences)

    @Update
    suspend fun updateUserPreferences(userPreferences: UserPreferences)

    @Query("Select * FROM user_preference Where user_id = :userid")
    fun getAllUserPreferences(userid : Int) : Flow<List<UserPreferences>>
}