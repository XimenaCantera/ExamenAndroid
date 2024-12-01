package com.example.kotlin.ninjaapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.domain.model.CovidInfo

class CovidAdapter(private val covidList: List<CovidInfo>) : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

    class CovidViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val country: TextView = view.findViewById(R.id.tvCountry)
        val activeCases: TextView = view.findViewById(R.id.tvActiveCases)
        val totalDeaths: TextView = view.findViewById(R.id.tvTotalDeaths)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid_info, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val covidInfo = covidList[position]
        holder.country.text = covidInfo.country
        holder.activeCases.text = "Casos activos: ${covidInfo.activeCases}"
        holder.totalDeaths.text = "Muertes: ${covidInfo.totalDeaths}"
    }

    override fun getItemCount(): Int = covidList.size
}
