package com.example.capstoneproject.data.database.userfavourite

import kotlinx.coroutines.flow.Flow

class UserFavouriteRepository(private val userFavouriteDao: UserFavouriteDao) {
    suspend fun insertUserFavourites(userFav: UserFavourite) = userFavouriteDao.insertUserFavourites(userFav)

    suspend fun deleteUserFavourites(favId: Int) = userFavouriteDao.deleteUserFavourites(favId)

    suspend fun updateRecurrence(
        id: Int,
        recur: Boolean,
        recurTime: String,
        recurDay: List<String>,
    ) = userFavouriteDao.updateRecurrence(
        id,
        recur,
        recurTime,
        recurDay,
    )

    fun getSpecificUserFav(userId: Int): Flow<List<UserFavourite>> = userFavouriteDao.getSpecificFavourites(userId)
}
