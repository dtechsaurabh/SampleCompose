package com.example.samplecompose.network.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {

    @Provides
    fun RetrofitInstance(): String = "https://micdelhi.in/coltapp/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val headerInterceptor = Interceptor { chain ->
            val originalRequest: Request = chain.request()
            val requestWithHeaders: Request =
                originalRequest.newBuilder()
                    .addHeader("Accept", "application/json")
                    .build()
            chain.proceed(requestWithHeaders)
        }

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideApiRequest(retrofit: Retrofit): ApiRequestInterface =
        retrofit.create(ApiRequestInterface::class.java)

    @Singleton
    @Provides
    fun provideApiInterface(apiRequest: ApiRequestInterface): ApiMethods =
        ApiMethods(apiRequest)

    @Singleton
    @Provides
    fun provideAppRepository(apiInterface: ApiMethods): AppRepository =
        AppRepository(apiInterface)
}