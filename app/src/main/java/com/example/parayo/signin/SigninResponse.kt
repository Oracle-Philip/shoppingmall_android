package com.example.parayo.signin

data class SigninResponse(
    val token: String,  val refreshToken: String,
    val userName: String, val userId: Long
)
