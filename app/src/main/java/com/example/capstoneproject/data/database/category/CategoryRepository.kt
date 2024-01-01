package com.example.capstoneproject.data.database.category

import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun insertCategory(category: Category)
    = categoryDao.insertCategory(category)
    suspend fun deleteCategory(categoryId: Int)
    = categoryDao.deleteCategory(categoryId)
    //suspend fun updateCategory(category: Category)
    //= categoryDao.updateCategory(category)
    fun getAllCategory(): Flow<List<Category?>>
    = categoryDao.getAllCategory()
    fun getSpecificCategory(name: String): Flow<Category?>
    = categoryDao.getSpecificCategory(name)
}