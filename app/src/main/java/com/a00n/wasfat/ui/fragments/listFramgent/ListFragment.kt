package com.a00n.wasfat.ui.fragments.listFramgent

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.a00n.wasfat.R
import com.a00n.wasfat.data.local.entities.Recipe
import com.a00n.wasfat.databinding.FragmentListBinding
import com.a00n.wasfat.ui.adapters.RecipeListAdapter
import com.a00n.wasfat.utils.convertDrawableToByteArray
import com.a00n.wasfat.utils.getRecipes

class ListFragment : Fragment() {


    private lateinit var viewModel: ListViewModel
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipeListAdapter: RecipeListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        _binding = FragmentListBinding.inflate(inflater, container, false)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
//        val list = ArrayList<Recipe>()
//        var recipe: Recipe = Recipe(
//            name = "BARBECUED CHICKEN PIZZA",
//            nbIngredients = 3,
//            image = R.drawable.pizza1,
//            duration = 25,
//            ingredientsDetails = "- 2 boneless skinless chicken breast halves (6 ounces each)\\n- 1/4 teaspoon pepper\\n- 1 cup barbecue sauce, divided\\n- 1 tube (13.8 ounces) refrigerated pizza crust\\n- 2 teaspoons olive oil\\n-2 cups shredded Gouda cheese\\n-1 small red onion, halved and thinly sliced\\n-1/4 cup minced fresh cilantro",
//            description = "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor. They're perfect for spur-of-the-moment cookouts and summer dinners on the patio. —Alicia Trevithick, Temecula, California",
//            preparation = "STEP 1:\\n\\n Sprinkle chicken with pepper; place on an oiled grill rack over medium heat. Grill, covered, until a thermometer reads 165°, 5-7 minutes per side, basting frequently with 1/2 cup barbecue sauce during the last 4 minutes. Cool slightly. Cut into cubes.\\n\\nSTEP 2:\\n\\n Divide dough in half. On a well- greased large sheet of heavy-duty foil, press each portion of dough into a 10x8-in. rectangle; brush lightly with oil. Invert dough onto grill rack; peel off foil. Grill, covered, over medium heat until bottom is lightly browned, 1-2 minutes.\\n\\nSTEP 3:\\n\\n Remove from grill. Spread grilled sides with remaining barbecue sauce. Top with cheese, chicken and onion. Grill, covered, until bottom is lightly browned and cheese is melted, 2-3 minutes. Sprinkle with cilantro. Yield: 2 pizzas (4 pieces each)."
//        )
//        viewModel.insert(Recipe(
//            name = "BARBECUED CHICKEN PIZZA",
//            nbIngredients = 3,
//            image = convertDrawableToByteArray(ContextCompat.getDrawable(requireContext(),R.drawable.pizza1)),
//            duration = 25,
//            ingredientsDetails = "- 2 boneless skinless chicken breast halves (6 ounces each)\\n- 1/4 teaspoon pepper\\n- 1 cup barbecue sauce, divided\\n- 1 tube (13.8 ounces) refrigerated pizza crust\\n- 2 teaspoons olive oil\\n-2 cups shredded Gouda cheese\\n-1 small red onion, halved and thinly sliced\\n-1/4 cup minced fresh cilantro",
//            description = "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor. They're perfect for spur-of-the-moment cookouts and summer dinners on the patio. —Alicia Trevithick, Temecula, California",
//            preparation = "STEP 1:\\n\\n Sprinkle chicken with pepper; place on an oiled grill rack over medium heat. Grill, covered, until a thermometer reads 165°, 5-7 minutes per side, basting frequently with 1/2 cup barbecue sauce during the last 4 minutes. Cool slightly. Cut into cubes.\\n\\nSTEP 2:\\n\\n Divide dough in half. On a well- greased large sheet of heavy-duty foil, press each portion of dough into a 10x8-in. rectangle; brush lightly with oil. Invert dough onto grill rack; peel off foil. Grill, covered, over medium heat until bottom is lightly browned, 1-2 minutes.\\n\\nSTEP 3:\\n\\n Remove from grill. Spread grilled sides with remaining barbecue sauce. Top with cheese, chicken and onion. Grill, covered, until bottom is lightly browned and cheese is melted, 2-3 minutes. Sprinkle with cilantro. Yield: 2 pizzas (4 pieces each)."
//        ))



        recipeListAdapter = RecipeListAdapter(requireContext(), ArrayList<Recipe>())
        binding.recipeListView.adapter = recipeListAdapter
        viewModel.recipes.observe(viewLifecycleOwner) {
            Log.i("info", "onCreateView: $it")
            if(it.isNullOrEmpty()){
                binding.emptyListLinearLayout.visibility = View.VISIBLE
            }
            else{
                binding.emptyListLinearLayout.visibility = View.GONE
            }
            recipeListAdapter.updateRecipeList(it)
        }
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}