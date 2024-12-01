package com.example.kotlin.ninjaapp.domain.usecase

import com.example.kotlin.ninjaapp.data.repository.CovidRepository
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
class GetCovidDataUseCase(private val repository: CovidRepository) {
    operator fun invoke(): List<CovidInfo> {
        return repository.getCovidData()
    }
}

