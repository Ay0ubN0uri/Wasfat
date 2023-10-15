package com.a00n.wasfat.ui.fragments.detailsFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.a00n.wasfat.R
import com.a00n.wasfat.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {


    private lateinit var viewModel: DetailsViewModel
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.recipe = args.recipe
        Log.i("info", "onCreateView: ${args.recipe}")
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}