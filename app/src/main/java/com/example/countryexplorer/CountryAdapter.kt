package com.example.countryexplorer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countryexplorer.databinding.ItemCountryBinding

class CountryAdapter(
    private val countries: List<CountryItem>,
    private val onItemClick: (CountryItem) -> Unit
) : RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
        holder.itemView.setOnClickListener { onItemClick(country) }
    }

    override fun getItemCount() = countries.size
}
