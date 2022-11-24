package com.example.parayo.api

import android.os.Build.HOST
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*
import java.util.concurrent.TimeUnit

class ApiGenerator {
    fun <T> generate(api: Class<T>): T = Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
        .create(api)

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            connectTimeout(100, TimeUnit.SECONDS)
            addInterceptor(httpLoggingInterceptor())
        }.build()

    private fun httpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    companion object {
        //const val HOST = "http://10.0.2.2:8080"
        //const val HOST = "http://192.168.0.68:8080"
        const val HOST = "https://weardoctor.uzzaggo.com/restAPI/test.do"
    }
}