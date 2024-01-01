package com.example.capstoneproject.data.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {
    //user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    //get all categories (retrieve the name and ids)
    @Query("Select * FROM user")
    fun getAllUser() : Flow<List<User>>

    //get specific user
    //(to retrieve specific user info using username
    // which matches username in database)
    @Query("Select * FROM user WHERE user_name = :username")
    fun getSpecificUser(username: String): Flow<User>
}