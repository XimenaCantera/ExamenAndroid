package com.example.kotlin.ninjaapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.utils.loadCovidData
import com.example.kotlin.ninjaapp.domain.model.CovidInfo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Carga los datos de COVID desde el archivo JSON local
        val covidData: List<CovidInfo> = loadCovidData(this)

        // Verifica que los datos estén siendo recibidos correctamente
        Log.d("CovidData", "Datos recibidos: $covidData")

        // Encuentra el TextView donde quieres mostrar los datos
        val textView: TextView = findViewById(R.id.textViewCovidData)

        // Convierte la lista de datos a un formato legible y actualiza el TextView
        val data = covidData.joinToString("\n") {
            "País: ${it.country}, Casos activos: ${it.activeCases}, Muertes: ${it.totalDeaths}"
        }

        // Actualiza el contenido del TextView
        textView.text = data
    }
}