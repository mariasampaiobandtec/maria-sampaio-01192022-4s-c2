package com.example.appcachorros

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCachorros {

    @POST("cachorros")
    fun post(@Body novoCachorro:Cachorro): Call<Cachorro>
}