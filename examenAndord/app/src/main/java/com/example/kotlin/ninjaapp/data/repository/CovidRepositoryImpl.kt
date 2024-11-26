package com.example.kotlin.ninjaapp.data.repository

import com.example.kotlin.ninjaapp.domain.model.CovidData
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import com.example.kotlin.ninjaapp.domain.repository.CovidRepository

class CovidRepositoryImpl : CovidRepository {

    // Simulando los datos
    private val simulatedCovidData = listOf(
        CovidData("USA", 1000000, 800000, 50000),
        CovidData("India", 950000, 850000, 45000),
        CovidData("Brazil", 900000, 700000, 40000)
    )

    override suspend fun getCovidData(apiKey: String): List<CovidInfo> {
        // Mapeamos los datos simulados a CovidInfo
        return simulatedCovidData.map {
            CovidInfo(
                country = it.country,
                activeCases = it.total_cases - it.total_recovered,
                totalDeaths = it.total_deaths
            )
        }
    }
}
