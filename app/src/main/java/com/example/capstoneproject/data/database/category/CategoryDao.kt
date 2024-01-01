package com.example.capstoneproject.data.database.category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    //Category
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Query("Delete From category where category_id = :categoryId")
    suspend fun deleteCategory(categoryId: Int)

    //@Update
    //suspend fun updateCategory(category: Category)

    //get all categories (retrieve the name and ids)
    @Query("Select * FROM category")
    fun getAllCategory() : Flow<List<Category?>>

    //get specific category (to retrieve specific ids which matches the input name)
    @Query("Select * FROM category WHERE category_name = :categoryName")
    fun getSpecificCategory(categoryName: String): Flow<Category?>

}