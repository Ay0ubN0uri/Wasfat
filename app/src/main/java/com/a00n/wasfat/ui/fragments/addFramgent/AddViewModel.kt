package com.a00n.wasfat.ui.fragments.addFramgent

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

class AddViewModel(application: Application) : AndroidViewModel(application) {


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


    fun validateRecipeName(text: String): String? {
        if (text.toString().length < 3) {
            return "Recipe name must contains at least 5 characters!!"
        }
        return null
    }

    fun validateIngredientsDetails(text: String): String? {
        if (text.toString().length < 100) {
            return "Must contains at least 100 characters!!"
        }
        return null
    }

    fun validateNbIngredients(text: String): String? {
        if (!text.matches(".*[0-9].*".toRegex())) {
            return "Must be all digits!!"
        }
        if (text.isEmpty()) {
            return "Must not be empty!!"
        }
        return null
    }

    fun validateDuration(text: String): String? {
        if (!text.matches(".*[0-9].*".toRegex())) {
            return "Must be all digits!!"
        }
        if (text.isEmpty()) {
            return "Must not be empty!!"
        }
        return null
    }


}