package com.example.kotlin.ninjaapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.domain.model.CaseData
import com.example.kotlin.ninjaapp.domain.model.CovidInfo


class CovidAdapter(private val covidInfo: CovidInfo) : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid_info, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val date = covidInfo.cases.entries.toList()[position]
        holder.bind(date.key, date.value)
    }

    // A card for a one date
    override fun getItemCount(): Int {
        return covidInfo.cases.size
    }

    inner class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(date: String, caseData: CaseData) {
            itemView.findViewById<TextView>(R.id.dateTextView).text = "Fecha: $date"
            itemView.findViewById<TextView>(R.id.casesTextView).text = "Casos Totales: ${caseData.total}\nCasos Nuevos: ${caseData.new}"
        }
    }
}