package com.example.kotlin.ninjaapp.data.api

import com.example.kotlin.ninjaapp.domain.model.CovidData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CovidApiService {

    @GET("covid19")  // El endpoint correcto de la API
    suspend fun getCovidData(
        @Header("X-Api-Key") apiKey: String  // Pasamos el API key como encabezado
    ): Response<List<CovidData>>

    companion object {
        fun create(): CovidApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("https://api.api-ninjas.com/v1/")  // Asegúrate de que la base URL sea correcta
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()

            return retrofit.create(CovidApiService::class.java)
        }
    }
}
