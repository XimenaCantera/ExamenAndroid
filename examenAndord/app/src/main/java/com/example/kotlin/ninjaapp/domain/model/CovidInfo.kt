package com.example.kotlin.ninjaapp.domain.model

data class CovidInfo(
    val country: String,
    val activeCases: Int,
    val totalDeaths: Int
)