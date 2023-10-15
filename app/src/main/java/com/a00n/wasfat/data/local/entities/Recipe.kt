package com.a00n.wasfat.data.local.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val nbIngredients: Int,
    val image: ByteArray,
    val duration: Int,
    val ingredientsDetails: String,
    val description: String,
    val preparation: String,
) : Parcelable
