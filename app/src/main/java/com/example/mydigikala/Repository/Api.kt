package com.example.mydigikala.Repository

import com.example.mydigikala.Model.Model_Home
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface Api {

    @GET("home.php")
    suspend fun Gethome_Response() : Response<Model_Home>

    companion object{
        operator fun invoke():Api{
            return Retrofit.Builder().baseUrl("http://192.168.0.101/digikala/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api::class.java)
        }

    }


}


