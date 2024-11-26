package com.example.kotlin.ninjaapp.domain.repository

import com.example.kotlin.ninjaapp.domain.model.CovidInfo

// Interfaz que define el repositorio, donde la función getCovidData será usada
interface CovidRepository {
    suspend fun getCovidData(apiKey: String): List<CovidInfo>
}
