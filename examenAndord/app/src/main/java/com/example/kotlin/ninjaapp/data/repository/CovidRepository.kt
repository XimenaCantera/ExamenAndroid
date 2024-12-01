package com.example.kotlin.ninjaapp.data.repository

import android.content.Context
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import com.example.kotlin.ninjaapp.utils.loadCovidData

class CovidRepository(private val context: Context) {
    fun getCovidData(): List<CovidInfo> {
        return loadCovidData(context)
    }
}