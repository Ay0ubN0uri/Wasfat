package com.a00n.wasfat.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.a00n.wasfat.data.local.entities.Recipe


@Dao
interface RecipeDao {
    @Insert
    suspend fun insert(recipe: Recipe)

    @Update
    suspend fun update(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("DELETE FROM recipes")
    suspend fun deleteAll()

    @Query("SELECT * FROM recipes WHERE id = :id")
    fun get(id: Long): LiveData<Recipe>

    @Query("SELECT * FROM recipes ORDER BY id DESC")
    fun getAll(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE name LIKE :query ORDER BY id DESC")
    fun search(query: String): LiveData<List<Recipe>>
}