package com.example.kotlin.ninjaapp.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.data.CovidRepository
import com.example.kotlin.ninjaapp.presentation.adapter.CovidAdapter
import com.example.kotlin.ninjaapp.presentation.viewModel.CovidViewModel
import com.example.kotlin.ninjaapp.domain.usecase.GetCovidDataUseCase
import com.example.kotlin.ninjaapp.presentation.viewModel.CovidViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var covidViewModel: CovidViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewCovid)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val repository = CovidRepository(this)
        val useCase = GetCovidDataUseCase(repository)
        val factory = CovidViewModelFactory(useCase)
        covidViewModel = ViewModelProvider(this, factory).get(CovidViewModel::class.java)

        covidViewModel.covidData.observe(this) { covidData ->
            recyclerView.adapter = CovidAdapter(covidData)
        }

        covidViewModel.loadCovidData()
    }
}