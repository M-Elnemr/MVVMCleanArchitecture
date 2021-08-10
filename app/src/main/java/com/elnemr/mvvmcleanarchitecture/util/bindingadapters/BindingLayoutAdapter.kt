package com.elnemr.mvvmcleanarchitecture.util.bindingadapters

class BindingLayoutAdapter {
    companion object {

//        @BindingAdapter("onRecipesClickListen")
//        @JvmStatic
//        fun onRecipesClickListen(view: ConstraintLayout, result: Result) {
//            view.setOnClickListener {
//                Log.d("TAG", "onRecipesClickListen: called")
//                try {
////                    val extras = FragmentNavigatorExtras(
////                        view.findViewById<ImageView>(R.id.recipe_image) to "imageTrans"
////                    )
//                    val action =
//                        RecipesFragmentDirections.actionRecipesFragmentToDetailsActivity(result)
//                    view.findNavController().navigate(action)
//                } catch (e: Exception) {
//                    Log.d("TAG", "onRecipesClickListen: $e")
//                }
//            }
//        }
//
//        @BindingAdapter("textInt")
//        @JvmStatic
//        fun setIntText(textView: TextView, intText: Int) {
//            textView.text = intText.toString()
//        }
//
//        @BindingAdapter("backgroundBooleanGreen")
//        @JvmStatic
//        fun changeBackgroundColor(view: View, data: Boolean) {
//            if (data) {
//                when (view) {
//                    is TextView -> {
//                        view.setTextColor(ContextCompat.getColor(view.context, R.color.green))
//                    }
//                    is ImageView -> {
//                        view.setColorFilter(ContextCompat.getColor(view.context, R.color.green))
//                    }
//                }
//            }else{
//                when (view) {
//                    is TextView -> {
//                        view.setTextColor(ContextCompat.getColor(view.context, R.color.darkGray))
//                    }
//                    is ImageView -> {
//                        view.setColorFilter(ContextCompat.getColor(view.context, R.color.darkGray))
//                    }
//                }
//            }
//
//        }
//
//        @BindingAdapter("loadImage")
//        @JvmStatic
//        fun loadImage(imageView: ImageView, url: String) {
//            imageView.load(url) {
//                crossfade(600)
//                error(R.drawable.ic_food_joke)
//                placeholder(R.drawable.ic_food_joke)
//            }
//        }
//
//        @BindingAdapter("readApiResponseImage", "readDatabaseImage", requireAll = true)
//        @JvmStatic
//        fun errorImageVisibilityRecipes(
//            imageView: ImageView,
//            response: NetworkResult<FoodRecipe>?,
//            database: List<RecipesEntity>?
//        ) {
//            if (response is NetworkResult.Error && database.isNullOrEmpty()) {
//                imageView.visibility = View.VISIBLE
//            } else {
//                imageView.visibility = View.INVISIBLE
//            }
//        }
//
//        @BindingAdapter("readApiResponseText", "readDatabaseText", requireAll = true)
//        @JvmStatic
//        fun errorTextVisibilityRecipes(
//            textView: TextView,
//            response: NetworkResult<FoodRecipe>?,
//            database: List<RecipesEntity>?
//        ) {
//            if (response is NetworkResult.Error && database.isNullOrEmpty()) {
//                textView.visibility = View.VISIBLE
//                textView.text = response.message.toString()
//            } else {
//                textView.visibility = View.INVISIBLE
//            }
//        }
//
//        @BindingAdapter("parseHtml")
//        @JvmStatic
//        fun parseHtml(textView: TextView, text: String?) {
//            if (text != null) {
//                val txt = Jsoup.parse(text).text()
//                textView.text = txt
//            }
//
//        }
//
    }

}