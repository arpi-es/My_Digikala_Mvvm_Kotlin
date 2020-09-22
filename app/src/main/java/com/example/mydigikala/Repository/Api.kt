package com.example.mydigikala.Repository

import com.example.mydigikala.HomeModel
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
        const val myIP = "http://192.168.1.3"
        private const val baseUrl = "http://192.168.1.3/digikala/api/"

    }


}


