package com.example.kotlin.ninjaapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import com.example.kotlin.ninjaapp.domain.usecase.GetCovidDataUseCase

class CovidViewModel(private val getCovidDataUseCase: GetCovidDataUseCase) : ViewModel() {

    private val _covidData = MutableLiveData<List<CovidInfo>>()
    val covidData: LiveData<List<CovidInfo>> get() = _covidData

    fun loadCovidData() {
        _covidData.value = getCovidDataUseCase()
    }
}
