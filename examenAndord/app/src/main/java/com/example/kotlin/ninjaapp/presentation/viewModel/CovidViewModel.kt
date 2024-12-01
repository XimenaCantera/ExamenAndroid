package com.example.kotlin.ninjaapp.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import com.example.kotlin.ninjaapp.utils.loadCovidData

class CovidViewModel(application: Application) : AndroidViewModel(application) {

    private val _covidData = MutableLiveData<List<CovidInfo>>()
    val covidData: LiveData<List<CovidInfo>> get() = _covidData

    init {
        // Send data from JSON
        _covidData.value = loadCovidData(getApplication())
    }
}
