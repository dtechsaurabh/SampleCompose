package com.example.samplecompose.network.retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import javax.inject.Inject

class ApiMethods @Inject constructor(private var apiRequest: ApiRequestInterface) {

    fun logIn(email: String, password: String): Call<JsonObject?>? {
        return apiRequest.logIn(email, password)
    }

}