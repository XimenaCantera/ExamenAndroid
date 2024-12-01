package com.example.kotlin.ninjaapp.data.network

import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CovidApiService {
    @GET("covid19")
    suspend fun getCovidData(
        @Query("country") country: String? = null,
        @Header("wLVPN1zV08lJYF7uXqgyPw==zVwp6TlVcAO1NLUf") apiKey: String
    ): Response<List<CovidInfo>>
}