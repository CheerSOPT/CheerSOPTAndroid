package com.example.cheersopt.network

import com.example.cheersopt.network.data.request.RequestBlenderData
import com.example.cheersopt.network.data.request.RequestPostRecipeData
import com.example.cheersopt.network.data.response.ResponseBlenderData
import com.example.cheersopt.network.data.response.ResponseDrinksData
import com.example.cheersopt.network.data.response.ResponsePostRecipeData
import com.example.cheersopt.network.data.response.ResponseRecipeData
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {
    //내서재 메인 프로필 조회
//    @GET("/my/profile")
//    fun lookLibraryProfile(
//            @Header("token") token: String?
//    ) : Call<ResponseMainLibraryData>

    // 랜덤 레시피 제조
    @POST("/recipe/blender")
    fun requestBlender(@Body body: RequestBlenderData) : Call<ResponseBlenderData>

    // 레시피 등록
    @POST("/recipe")
    fun postRecipe(@Body body: RequestPostRecipeData) : Call<ResponsePostRecipeData>

    // 레시피 리스트 조회
    @GET("/recipe")
    fun requestRecipe(
    ) : Call<ResponseRecipeData>

    // 레시피 리스트 조회
    @GET("/drinks")
    fun requestDrinks(
    ) : Call<ResponseDrinksData>
}