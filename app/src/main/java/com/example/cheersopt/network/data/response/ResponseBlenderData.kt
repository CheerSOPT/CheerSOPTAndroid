package com.example.cheersopt.network.data.response

data class ResponseBlenderData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : BlenderData
)

data class BlenderData(
    val drink_1_name : String,
    val three_ratio1 : String,
    val drink_2_name : String,
    val three_ratio2 : String,
    val drink_3_name : String,
    val three_ratio3 : String,
    val three_recipe_stack : ArrayList<String>,
    val blended_count_3 : Int
)