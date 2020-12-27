package com.example.cheersopt.network.data.response

import com.example.cheersopt.network.data.RatioData

data class ResponseBlenderData (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : BlenderData
)

data class BlenderData(
    var ratios : ArrayList<RatioData>,
    var recipeLevel_3 : Int,
    var three_recipe_stack : ArrayList<String>,
    var blended_count_3 : Int
)
