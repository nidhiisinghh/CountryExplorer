package com.example.countryexplorer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryexplorer.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CountryAdapter
    private var allCountries: List<CountryItem> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        fetchCountries()
    }

    private fun setupRecyclerView() {
        adapter = CountryAdapter(emptyList()) { country ->
            val intent = Intent(this, CountryDetail::class.java)
            intent.putExtra("country", country)
            startActivity(intent)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun fetchCountries() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE

        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getCountries()
                allCountries = response
                adapter = CountryAdapter(response) { country ->
                    val intent = Intent(this@MainActivity, CountryDetail::class.java)
                    intent.putExtra("country", country)
                    startActivity(intent)
                }
                binding.recyclerView.adapter = adapter
                binding.recyclerView.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}