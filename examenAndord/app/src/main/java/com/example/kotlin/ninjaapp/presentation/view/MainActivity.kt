package com.example.kotlin.ninjaapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.presentation.viewModel.CovidViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var covidViewModel: CovidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instanciamos el ViewModel directamente
        covidViewModel = ViewModelProvider(this).get(CovidViewModel::class.java)

        // Llamamos al método que asigna los datos simulados
        covidViewModel.getCovidData()

        // Observa el LiveData y actualiza el UI
        covidViewModel.covidData.observe(this, Observer { covidInfo ->
            // Verifica que los datos estén siendo recibidos correctamente
            Log.d("CovidData", "Datos recibidos: $covidInfo")

            // Encuentra el TextView donde quieres mostrar los datos
            val textView: TextView = findViewById(R.id.textViewCovidData)

            // Convierte la lista de datos a un formato legible y actualiza el TextView
            val data = covidInfo.joinToString("\n") {
                "País: ${it.country}, Casos activos: ${it.activeCases}, Muertes: ${it.totalDeaths}"
            }

            // Actualiza el contenido del TextView
            textView.text = data
        })
    }
}
