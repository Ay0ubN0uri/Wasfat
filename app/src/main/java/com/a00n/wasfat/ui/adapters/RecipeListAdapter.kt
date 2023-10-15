package com.a00n.wasfat.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.a00n.wasfat.R
import com.a00n.wasfat.data.local.entities.Recipe
import com.a00n.wasfat.databinding.ListItemBinding

class RecipeListAdapter(context: Context, private val list: ArrayList<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.list_item, list) {

    private val recipeList: ArrayList<Recipe> = list
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val recipe = getItem(position)
        val binding: ListItemBinding

        if (convertView == null) {
            binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ListItemBinding
        }

        binding.recipe = recipe
        return binding.root
    }

    fun updateRecipeList(newList: List<Recipe>) {
        recipeList.clear()
        recipeList.addAll(newList)
        notifyDataSetChanged()
    }

}