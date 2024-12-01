package com.example.kotlin.ninjaapp.presentation.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.domain.model.CovidInfo
import com.example.kotlin.ninjaapp.utils.loadCovidData
import com.example.kotlin.ninjaapp.presentation.adapter.CovidAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain data
        val covidInfoList: List<CovidInfo> = loadCovidData(this)
        val countryName = covidInfoList.first().country

        // Show name's country
        val countryTextView: TextView = findViewById(R.id.countryTextView)
        countryTextView.text = countryName

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = CovidAdapter(covidInfoList.first())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
