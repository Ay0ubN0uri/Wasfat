package com.a00n.wasfat.ui.fragments.addFramgent

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.fragment.findNavController
import com.a00n.wasfat.R
import com.a00n.wasfat.data.local.entities.Recipe
import com.a00n.wasfat.databinding.FragmentAddBinding
import com.a00n.wasfat.utils.convertBitmapToByteArray
import com.a00n.wasfat.utils.convertDrawableToByteArray
import com.google.android.material.snackbar.Snackbar

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AddViewModel
    private var imgUri: Uri? = null
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        it?.let {
            imgUri = it
            binding.recipeImageView.setImageURI(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AddViewModel::class.java]
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        registerClickEvents()
        focusListeners()
        return binding.root
    }

    private fun focusListeners() {
        binding.recipeNameEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.recipeNameInput.helperText =
                    viewModel.validateRecipeName(binding.recipeNameEditText.text.toString())
            }
        }
        binding.nbIngredientsEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.nbIngredientsInput.helperText =
                    viewModel.validateNbIngredients(binding.nbIngredientsEditText.text.toString())
            }
        }
        binding.durationEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.durationInput.helperText =
                    viewModel.validateDuration(binding.durationEditText.text.toString())
            }
        }
        binding.ingredientsDetailsEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.ingredientsDetailsInput.helperText =
                    viewModel.validateIngredientsDetails(binding.ingredientsDetailsEditText.text.toString())
            }
        }
        binding.descriptionEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.descriptionInput.helperText =
                    viewModel.validateIngredientsDetails(binding.descriptionEditText.text.toString())
            }
        }
        binding.preparationEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.preparationInput.helperText =
                    viewModel.validateIngredientsDetails(binding.preparationEditText.text.toString())
            }
        }
    }

    private fun registerClickEvents() {
        binding.recipeImageView.setOnClickListener {
            resultLauncher.launch("image/*")
        }
        binding.addButton.setOnClickListener { submitForm() }
    }

    private fun submitForm() {
        if (isFormValid()) {
            Log.i("info", "submitForm: all is good")
            binding.let {
                val recipe = Recipe(
                    name = it.recipeNameEditText.text.toString(),
                    nbIngredients = it.nbIngredientsEditText.text.toString().toInt(),
                    image = convertDrawableToByteArray(binding.recipeImageView.drawable),
                    duration = it.durationEditText.text.toString().toInt(),
                    ingredientsDetails = it.ingredientsDetailsEditText.text.toString(),
                    description = it.descriptionEditText.text.toString(),
                    preparation = it.preparationEditText.text.toString()
                )
                Log.i("info", "submitForm: $recipe")
                viewModel.insert(recipe)
                Snackbar.make(
                    binding.root,
                    "Recipe Added Successfully",
                    Snackbar.LENGTH_LONG
                ).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
        } else {
            Snackbar.make(binding.root, "Please fill all fields", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun isFormValid(): Boolean {
        var valid = false
        binding.let {
            valid = it.recipeNameInput.helperText == null &&
                    it.descriptionInput.helperText == null &&
                    it.ingredientsDetailsInput.helperText == null &&
                    it.preparationInput.helperText == null &&
                    it.nbIngredientsInput.helperText == null &&
                    it.durationInput.helperText == null && isImageValid()
        }
        return valid
    }

    private fun isImageValid(): Boolean {
        val drawableToCompare = resources.getDrawable(R.drawable.upload_image_placeholder, null)
        val imageViewBitmap = (binding.recipeImageView.drawable as? BitmapDrawable)?.bitmap
        val drawableBitmap = (drawableToCompare as? BitmapDrawable)?.bitmap
        return if (imageViewBitmap != null && drawableBitmap != null) {
            if (areBitmapsEqual(imageViewBitmap, drawableBitmap)) {
                Log.i("info", "submitForm: The image in the ImageView and the Drawable are equal.")
                false
            } else {
                Log.i("info", "submitForm: The images are not equal.")
                true
            }
        } else {
            Log.i(
                "info",
                "submitForm: Handle cases where either the ImageView or the Drawable does not have a Bitmap."
            )
            false
        }
    }

    private fun areBitmapsEqual(bitmap1: Bitmap, bitmap2: Bitmap): Boolean {
        return bitmap1.sameAs(bitmap2)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}