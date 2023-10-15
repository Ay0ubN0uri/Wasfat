package com.a00n.wasfat.ui.adapters

import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.a00n.wasfat.R
import com.a00n.wasfat.data.local.entities.Recipe
import com.a00n.wasfat.ui.fragments.listFramgent.ListFragmentDirections


@BindingAdapter("loadImage")
fun ImageView.loadImage(img: ByteArray) {
    this.load(img) {
        crossfade(600)
        error(R.drawable.error_placeholder)
    }
}


@BindingAdapter("numberOfMinutes")
fun TextView.numberOfMinutes(min: Int) {
    this.text = min.toString()
}



@BindingAdapter("onRecipesClickListener")
fun ConstraintLayout.onRecipesClickListener(recipe: Recipe){
    this.setOnClickListener {
        Log.i("info", "onRecipesClickListener: hello")
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(recipe)
        this.findNavController().navigate(action)
    }
}


