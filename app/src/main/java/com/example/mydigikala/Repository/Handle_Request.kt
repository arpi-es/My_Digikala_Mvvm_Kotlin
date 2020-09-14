package com.example.mydigikala.Repository

import retrofit2.Response


object Handle_Request : Repository() {


    suspend fun <T:Any>  Request(response: Response<T>) = CustomResponse { response }
}