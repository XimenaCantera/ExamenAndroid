package com.example.kotlin.ninjaapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.ninjaapp.R
import com.example.kotlin.ninjaapp.databinding.ItemCovidBinding
import com.example.kotlin.ninjaapp.domain.model.CovidInfo

class CovidAdapter : ListAdapter<CovidInfo, CovidAdapter.CovidViewHolder>(CovidDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val covidInfo = getItem(position)
        holder.bind(covidInfo)
    }

    inner class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val countryTextView: TextView = itemView.findViewById(R.id.countryTextView)
        private val activeCasesTextView: TextView = itemView.findViewById(R.id.activeCasesTextView)
        private val totalDeathsTextView: TextView = itemView.findViewById(R.id.totalDeathsTextView)

        fun bind(covidInfo: CovidInfo) {
            countryTextView.text = covidInfo.country
            activeCasesTextView.text = "Active cases: ${covidInfo.activeCases}"
            totalDeathsTextView.text = "Total deaths: ${covidInfo.totalDeaths}"
        }
    }

    class CovidDiffCallback : DiffUtil.ItemCallback<CovidInfo>() {
        override fun areItemsTheSame(oldItem: CovidInfo, newItem: CovidInfo): Boolean {
            return oldItem.country == newItem.country
        }

        override fun areContentsTheSame(oldItem: CovidInfo, newItem: CovidInfo): Boolean {
            return oldItem == newItem
        }
    }
}

