package com.example.mydigikala.repository

import retrofit2.Response


object HandleRequest : Repository() {


    suspend fun <T:Any>  Request(response: Response<T>) = CustomResponse { response }
}