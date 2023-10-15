package com.a00n.wasfat.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.a00n.wasfat.R
import com.a00n.wasfat.data.local.entities.Recipe
import java.io.ByteArrayOutputStream


fun convertDrawableToByteArray(drawable: Drawable?): ByteArray {
    val bitmap = (drawable as BitmapDrawable).bitmap
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}
fun convertBitmapToByteArray(bitmap: Bitmap): ByteArray {
    val outputStream = ByteArrayOutputStream()
    bitmap.compress(CompressFormat.JPEG, 100, outputStream) // You can change the format and quality as needed
    return outputStream.toByteArray()
}

fun getRecipes(context: Context) : ArrayList<Recipe>{
    val list = listOf<Recipe>(
        Recipe(
            name = "BARBECUED CHICKEN PIZZA",
            nbIngredients = 3,
            image = convertDrawableToByteArray(ContextCompat.getDrawable(context,R.drawable.pizza1)),
            duration = 25,
            ingredientsDetails = "- 2 boneless skinless chicken breast halves (6 ounces each)\\n- 1/4 teaspoon pepper\\n- 1 cup barbecue sauce, divided\\n- 1 tube (13.8 ounces) refrigerated pizza crust\\n- 2 teaspoons olive oil\\n-2 cups shredded Gouda cheese\\n-1 small red onion, halved and thinly sliced\\n-1/4 cup minced fresh cilantro",
            description = "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor. They're perfect for spur-of-the-moment cookouts and summer dinners on the patio. —Alicia Trevithick, Temecula, California",
            preparation = "STEP 1:\\n\\n Sprinkle chicken with pepper; place on an oiled grill rack over medium heat. Grill, covered, until a thermometer reads 165°, 5-7 minutes per side, basting frequently with 1/2 cup barbecue sauce during the last 4 minutes. Cool slightly. Cut into cubes.\\n\\nSTEP 2:\\n\\n Divide dough in half. On a well- greased large sheet of heavy-duty foil, press each portion of dough into a 10x8-in. rectangle; brush lightly with oil. Invert dough onto grill rack; peel off foil. Grill, covered, over medium heat until bottom is lightly browned, 1-2 minutes.\\n\\nSTEP 3:\\n\\n Remove from grill. Spread grilled sides with remaining barbecue sauce. Top with cheese, chicken and onion. Grill, covered, until bottom is lightly browned and cheese is melted, 2-3 minutes. Sprinkle with cilantro. Yield: 2 pizzas (4 pieces each)."
        ),
        Recipe(
            name = "BRUSCHETTA PIZZA",
            nbIngredients = 5,
            image = convertDrawableToByteArray(ContextCompat.getDrawable(context,R.drawable.pizza2)),
            duration = 35,
            ingredientsDetails = "- 1/2 pound reduced-fat bulk pork sausage\\n- 1 prebaked 12-inch pizza crust\\n- 1 package (6 ounces) sliced turkey pepperoni\\n- 2 cups shredded part-skim mozzarella cheese\\n- 1-1/2 cups chopped plum tomatoes\\n- 1/2 cup fresh basil leaves, thinly sliced\\n- 1 tablespoon olive oil\\n- 2 garlic cloves, minced\\n- 1/2 teaspoon minced fresh thyme or 1/8 teaspoon dried thyme\\n- 1/2 teaspoon balsamic vinegar\\n- 1/4 teaspoon salt\\n- 1/8 teaspoon pepper\\n- Additional fresh basil leaves, optional",
            description = "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes, it's bound to become a family favorite. It's even better with a homemade, whole wheat crust! —Debra Kell, Owasso, Oklahoma",
            preparation = "STEP 1:\\n\\n In a small skillet, cook sausage over medium heat until no longer pink; drain. Place crust on an ungreased baking sheet. Top with pepperoni, sausage and cheese. Bake at 450° for 10-12 minutes or until cheese is melted.\\n\\nSTEP 2:\\n\\n In a small bowl, combine the tomatoes, sliced basil, oil, garlic, thyme, vinegar, salt and pepper. Spoon over pizza. Garnish with additional basil if desired. Yield: 8 slices."
        ),
//        Recipe(
//            name = "BRUSCHETTA PIZZA",
//            nbIngredients = 5,
//            image = convertDrawableToByteArray(ContextCompat.getDrawable(context,R.drawable.pizza3)),
//            duration = 35,
//            ingredientsDetails = "- 1/2 pound reduced-fat bulk pork sausage\\n- 1 prebaked 12-inch pizza crust\\n- 1 package (6 ounces) sliced turkey pepperoni\\n- 2 cups shredded part-skim mozzarella cheese\\n- 1-1/2 cups chopped plum tomatoes\\n- 1/2 cup fresh basil leaves, thinly sliced\\n- 1 tablespoon olive oil\\n- 2 garlic cloves, minced\\n- 1/2 teaspoon minced fresh thyme or 1/8 teaspoon dried thyme\\n- 1/2 teaspoon balsamic vinegar\\n- 1/4 teaspoon salt\\n- 1/8 teaspoon pepper\\n- Additional fresh basil leaves, optional",
//            description = "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes, it's bound to become a family favorite. It's even better with a homemade, whole wheat crust! —Debra Kell, Owasso, Oklahoma",
//            preparation = "STEP 1:\\n\\n In a small skillet, cook sausage over medium heat until no longer pink; drain. Place crust on an ungreased baking sheet. Top with pepperoni, sausage and cheese. Bake at 450° for 10-12 minutes or until cheese is melted.\\n\\nSTEP 2:\\n\\n In a small bowl, combine the tomatoes, sliced basil, oil, garlic, thyme, vinegar, salt and pepper. Spoon over pizza. Garnish with additional basil if desired. Yield: 8 slices."
//        ),

    )
    return ArrayList(list)
}