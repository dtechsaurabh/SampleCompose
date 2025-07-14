package com.example.samplecompose.network.retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiRequestInterface {
    @GET("index.php")
    fun logIn(
        @Query("username") username: String,
        @Query("password") password: String,
    ): Call<JsonObject?>?
}