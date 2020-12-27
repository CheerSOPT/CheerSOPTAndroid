package com.example.cheersopt.network.data.request

import com.example.cheersopt.network.data.RatioData

data class RequestPostRecipeData (
    var recipeName : String,
    var recipeLevel : Int,
    var ratios : ArrayList<RatioData>
)
