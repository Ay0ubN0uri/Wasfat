package com.a00n.wasfat.data.repository

import androidx.lifecycle.LiveData
import com.a00n.wasfat.data.local.dao.RecipeDao
import com.a00n.wasfat.data.local.entities.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {
    val recipes: LiveData<List<Recipe>> = recipeDao.getAll()

    suspend fun insert(recipe: Recipe) {
        recipeDao.insert(recipe)
    }

    suspend fun delete(recipe: Recipe) {
        recipeDao.delete(recipe)
    }

    suspend fun deleteAll() = recipeDao.deleteAll()


    fun search(query: String): LiveData<List<Recipe>> = recipeDao.search(query)
}