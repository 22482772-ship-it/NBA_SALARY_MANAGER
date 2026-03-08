package com.example.nba_salary_manager.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // --- CONFIGURACIÓN NBA ---
    private const val BASE_URL_NBA = "https://api.balldontlie.io/v1/"
    private const val API_KEY = "52dce931-a79f-44da-8a1a-aa9fa102dbbc"

    private val authInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", API_KEY)
            .build()
        chain.proceed(request)
    }

    private val okHttpClientNba = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    val api: NbaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_NBA)
            .client(okHttpClientNba)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NbaApiService::class.java)
    }

    // --- CONFIGURACIÓN TU PROPIA API (LOGIN) ---
    // Si pruebas en el emulador de Android, usa "http://10.0.2.2/" para referirte al localhost de tu PC
    private const val BASE_URL_MYSYSTEM = "http://10.0.2.2/mi_api_nba/"

    val authApi: AuthApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_MYSYSTEM)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }
}