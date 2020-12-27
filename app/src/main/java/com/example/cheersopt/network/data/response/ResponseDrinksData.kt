package com.example.cheersopt.network.data.response


data class ResponseDrinksData (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : DrinksData
)

data class DrinksData(
    val drinks_idx : Int,
    val drinks_name : String
)
