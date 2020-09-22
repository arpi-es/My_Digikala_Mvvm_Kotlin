package com.example.mydigikala.Repository

import android.util.Log
import retrofit2.Response
import java.lang.Exception

abstract class Repository {


    // ye chizi az jense api midim behesh, chem mikone age succes bud ->  body ro bar migardune

    suspend fun <T:Any> CustomResponse(work : () -> Response<T> ) : T {

        val response = work.invoke()

        // if isSuccessful and not null return the body, else throw an exeption with the message
        if (response.isSuccessful){
            return response.body()!!
        }else{
              throw Exception(response.message())
        }
    }
}