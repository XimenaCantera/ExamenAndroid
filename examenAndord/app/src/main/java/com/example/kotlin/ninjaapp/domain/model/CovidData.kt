package com.example.kotlin.ninjaapp.domain.model

// Modelo que simula los datos de COVID (usaremos estos datos en vez de hacer la llamada a la API)
data class CovidData(
    val country: String,
    val total_cases: Int,
    val total_recovered: Int,
    val total_deaths: Int
)
