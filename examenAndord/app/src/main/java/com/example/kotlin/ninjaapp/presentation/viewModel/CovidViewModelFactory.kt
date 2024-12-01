package com.example.kotlin.ninjaapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.ninjaapp.domain.usecase.GetCovidDataUseCase

class CovidViewModelFactory(private val useCase: GetCovidDataUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CovidViewModel::class.java)) {
            return CovidViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}