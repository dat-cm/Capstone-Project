package com.example.capstoneproject.data.database.userfavourite

import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.user.UserDao
import kotlinx.coroutines.flow.Flow

class UserFavouriteRepository(private val userFavouriteDao: UserFavouriteDao) {
    suspend fun insertUserFavourites(userFav: UserFavourite)
        = userFavouriteDao.insertUserFavourites(userFav)
    suspend fun deleteUserFavourites(favId: Int)
        = userFavouriteDao.deleteUserFavourites(favId)
    fun getSpecificUserFav(userId: Int): Flow<List<UserFavourite>>
        = userFavouriteDao.getAllUserFavourites(userId)
}