package com.example.capstoneproject.data.database.userfavourite

import androidx.room.Dao
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

    @Query(
        "Update user_favourite Set recurring = :recur, recurTime = :recurTime, recurDate = :recurDay Where " +
            "fav_id = :id",
    )
    suspend fun updateRecurrence(
        id: Int,
        recur: Boolean,
        recurTime: String,
        recurDay: List<String>,
    )

    @Query("Select * From user_favourite Where user_id = :userId")
    fun getSpecificFavourites(userId: Int): Flow<List<UserFavourite>>
}
