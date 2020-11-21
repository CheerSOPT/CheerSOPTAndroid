package com.example.cheersopt.network.data.response

data class ResponseRecipeData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : RecipeData
)

data class RecipeData(
    val recipe_name : String,
    val recipe_level : Int,
    val RATIO_TBs : ArrayList<RATIO>
)

data class RATIO(
    val drinks_idx : Int,
    val ratio_percent : Int,
    val DRINKS_TB : DRINKS
)

data class DRINKS(
    val drinks_name : String
)