package com.example.countryexplorer

import com.bumptech.glide.Glide
import com.example.countryexplorer.databinding.ItemCountryBinding
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

class CountryViewHolder(private val binding: ItemCountryBinding) : 
    RecyclerView.ViewHolder(binding.root) {
    
    fun bind(country: CountryItem) {
        binding.apply {
            tvCountryName.text = country.name.common
            tvRegion.text = country.region
            tvPopulation.text = "Population: ${country.population}"
            
            Glide.with(ivFlag)
                .load(country.flags.png)
                .into(ivFlag)
        }
    }
}