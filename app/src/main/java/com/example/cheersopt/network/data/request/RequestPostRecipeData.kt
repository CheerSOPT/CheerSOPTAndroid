package com.example.cheersopt.network.data.request

data class RequestPostRecipeData (
    val recipeName : String,
    val recipeLevel : Int,
    val ratios : ArrayList<RatioData>
)

data class RatioData(
    val drinksIdx : Int,
    val ratioPercent : Int
)