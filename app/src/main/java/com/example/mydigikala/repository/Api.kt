package com.example.mydigikala.repository

import com.example.mydigikala.model.HomeModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface Api {

    @GET("home.php")
    suspend fun getHomeResponse() : Response<HomeModel>

    companion object{
        operator fun invoke():Api{
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api::class.java)
        }
        const val myIP = "http://192.168.0.103"
        private const val baseUrl = "$myIP/digikala/api/"

    }


}


