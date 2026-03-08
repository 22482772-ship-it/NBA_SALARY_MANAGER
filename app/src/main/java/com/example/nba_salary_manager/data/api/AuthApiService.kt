package com.example.nba_salary_manager.data.api

import com.example.nba_salary_manager.data.model.LoginRequest
import com.example.nba_salary_manager.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("login.php")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}