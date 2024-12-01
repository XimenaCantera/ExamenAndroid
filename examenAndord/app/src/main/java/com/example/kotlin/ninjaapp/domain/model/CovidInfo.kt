package com.example.kotlin.ninjaapp.domain.model

data class CovidInfo(
    val country: String,
    val region: String?,
    val cases: Map<String, CaseData>
)

data class CaseData(
    val total: Int,
    val new: Int
)

