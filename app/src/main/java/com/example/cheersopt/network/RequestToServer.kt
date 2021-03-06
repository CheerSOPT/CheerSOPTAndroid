package com.example.cheersopt.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object는 코틀린에서 싱글톤이라는 것을 사용
//싱글톤이란 이 앱에서 유일한 객체, 딱 하나만 객체 생성을 하여 사용 > 메모리 절약
object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://54.180.189.240:5000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //실체 구현체 생성 부분
    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}