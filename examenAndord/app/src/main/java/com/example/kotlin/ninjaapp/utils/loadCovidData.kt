package com.example.kotlin.ninjaapp.utils

import android.content.Context
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

fun loadCovidData(context: Context): List<CovidInfo> {
    // Open JSON
    val inputStream = context.resources.openRawResource(R.raw.covid_data)
    val reader = InputStreamReader(inputStream)
    val type = object : TypeToken<List<CovidInfo>>() {}.type

    // JSON as a objet list `CovidInfo`
    return Gson().fromJson(reader, type)
}
