package com.example.parayo.api

import com.example.parayo.api.response.ApiResponse
import com.example.parayo.signup.SignupRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ParayoApi {
    @GET("/api/v1/hello")
    suspend fun hello(): ApiResponse<String>

    @POST("/api/v1/users")
    suspend fun signup(@Body signupRequest: SignupRequest) : ApiResponse<Void>

    companion object {
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)
    }
}