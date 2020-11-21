package com.example.cheersopt.network.data.response


data class ResponseDrinksData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : DrinksData
)

data class DrinksData(
    val drinks_idx : Int,
    val drinks_name : String
)
