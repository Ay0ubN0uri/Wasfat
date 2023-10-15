package com.a00n.wasfat.ui.fragments.listFramgent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a00n.wasfat.data.local.RecipeDatabase
import com.a00n.wasfat.data.local.dao.RecipeDao
import com.a00n.wasfat.data.local.entities.Recipe
import com.a00n.wasfat.data.repository.RecipeRepository
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private var recipeDao: RecipeDao

    private var recipeRepository: RecipeRepository
    var recipes: LiveData<List<Recipe>>

    init {
        recipeDao = RecipeDatabase.getDatabase(context = application.applicationContext).recipeDao
        recipeRepository = RecipeRepository(recipeDao)
        recipes = recipeRepository.recipes
    }


    fun insert(recipe: Recipe) {
        viewModelScope.launch {
            recipeRepository.insert(recipe)
        }
    }


    fun deleteAll() = viewModelScope.launch { recipeRepository.deleteAll() }


}