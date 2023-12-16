package com.example.recycleryretrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getEntriesByCategory(@Url url: String): Response<appResponse>

    @GET
    suspend fun getAllEntries(): Response<appResponse>
}