package com.example.cheersopt.network.data.response

import com.example.cheersopt.network.data.RatioData

data class ResponseBlenderData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : BlenderData
)

data class BlenderData(
    var ratios : ArrayList<RatioData>,
    var recipeLevel_3 : Int,
    val three_recipe_stack : ArrayList<String>,
    val blended_count_3 : Int
)
