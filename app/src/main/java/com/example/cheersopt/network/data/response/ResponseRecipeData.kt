package com.example.cheersopt.network.data.response

data class ResponseRecipeData(
    val data: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val RATIO_TBs: List<RATIOTB>,
        val recipe_level: Int,
        val recipe_name: String
    ) {
        data class RATIOTB(
            val DRINKS_TB: DRINKSTB,
            val drinks_idx: Int,
            val ratio_percent: Int
        ) {
            data class DRINKSTB(
                val drinks_name: String
            )
        }
    }
}