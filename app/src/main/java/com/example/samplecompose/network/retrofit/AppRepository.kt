package com.example.samplecompose.network.retrofit

import com.example.samplecompose.network.retrofit.response.BaseResponse
import com.example.samplecompose.network.retrofit.response.SingleLiveEvent
import com.example.samplecompose.utils.LoaderState
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class AppRepository @Inject constructor(private val apiMethods: ApiMethods) {

    fun logIn(
        email: String,
        password: String
    ): SingleLiveEvent<BaseResponse<JsonObject>> {
        LoaderState.show()

        val data: SingleLiveEvent<BaseResponse<JsonObject>> = SingleLiveEvent()
        val obj: BaseResponse<JsonObject> = BaseResponse()

        apiMethods.logIn(
            email,
            password
        )?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(
                call: Call<JsonObject?>,
                response: Response<JsonObject?>,
            ) {
                LoaderState.hide()
                try {

                    if (response.body() != null) {
                        obj.setResponseAlt(response.body()!!)
                        obj.setIsErrorAlt(false)
                    } else {
                        obj.setMessageAlt("Server error")
                        obj.setIsErrorAlt(true)
                    }
                    data.value = obj
                } catch (e: Exception) {
                    obj.setIsErrorAlt(true)
                    obj.setMessageAlt(e.message.toString())
                    data.value = obj
                }
            }

            override fun onFailure(
                call: Call<JsonObject?>,
                t: Throwable,
            ) {
                LoaderState.hide()
                obj.setIsErrorAlt(true)
                obj.setMessageAlt(t.message.toString())
                data.value = obj
            }

        })

        return data
    }

}