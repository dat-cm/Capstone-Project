package com.example.capstoneproject.data.database.userfavourite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserFavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserFavourites(userFavourite: UserFavourite)

    @Query("Delete From user_favourite Where fav_id = :favId")
    suspend fun deleteUserFavourites(favId: Int)

    @Query("Select * From user_favourite Where user_id = :userId")
    fun getAllUserFavourites(userId: Int): Flow<List<UserFavourite>>
}