package com.example.kotlin.ninjaapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin.ninjaapp.domain.model.CovidInfo

class CovidViewModel : ViewModel() {

    // Cambié a LiveData para que pueda ser observado en la UI
    private val _covidData = MutableLiveData<List<CovidInfo>>()
    val covidData: LiveData<List<CovidInfo>> get() = _covidData

    // Simulación de datos (sin necesidad de repositorio)
    fun getCovidData() {
        val simulatedData = listOf(
            CovidInfo("USA", 200000, 50000),
            CovidInfo("India", 100000, 45000),
            CovidInfo("Brazil", 200000, 40000)
        )

        _covidData.value = simulatedData
    }
}
