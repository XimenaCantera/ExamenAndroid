package com.example.kotlin.ninjaapp.domain.model

// Este modelo es para lo que mostrarás en la UI
data class CovidInfo(
    val country: String,
    val activeCases: Int,
    val totalDeaths: Int
)
