package com.example.cheersopt.network.data.response

data class ResponseRecipeData(
    var data: List<Data>,
    var message: String,
    var status: Int,
    var success: Boolean
) {
    data class Data(
        var RATIO_TBs: List<RATIOTB>,
        var recipe_level: Int,
        var recipe_name: String
    ) {
        data class RATIOTB(
            var DRINKS_TB: DRINKSTB,
            var drinks_idx: Int,
            var ratio_percent: Int
        ) {
            data class DRINKSTB(
                var drinks_name: String
            )
        }
    }
}