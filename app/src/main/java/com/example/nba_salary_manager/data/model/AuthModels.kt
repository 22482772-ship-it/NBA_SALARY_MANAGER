package com.example.nba_salary_manager.data.model// Lo que envías al servidor
data class LoginRequest(
    val email: String,
    val password: String
)

// Lo que recibes del servidor
data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val message: String?
)