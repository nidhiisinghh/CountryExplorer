package com.example.countryexplorer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.countryexplorer.databinding.ActivityCountryDetailBinding

class CountryDetail : AppCompatActivity() {
    private lateinit var binding: ActivityCountryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = intent.getSerializableExtra("country") as? CountryItem
        country?.let { displayCountryDetails(it) }
    }

    private fun displayCountryDetails(country: CountryItem) {
        binding.apply {
            tvCountryName.text = country.name.common
            tvCapital.text = "Capital: ${country.capital?.firstOrNull() ?: "N/A"}"
            tvRegion.text = "Region: ${country.region}"
            tvPopulation.text = "Population: ${country.population}"
            tvArea.text = "Area: ${country.area ?: "N/A"} km²"
            
            val currenciesText = country.currencies?.map { (code, currency) ->
                "$code (${currency.name})"
            }?.joinToString(", ") ?: "N/A"
            tvCurrencies.text = "Currencies: $currenciesText"
            
            val languagesText = country.languages?.values?.joinToString(", ") ?: "N/A"
            tvLanguages.text = "Languages: $languagesText"

            Glide.with(this@CountryDetail)
                .load(country.flags.png)
                .into(ivFlag)
        }
    }
}