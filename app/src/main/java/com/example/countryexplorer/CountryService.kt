package com.example.countryexplorer

import retrofit2.http.GET

interface CountryService {
    @GET("v3.1/all")
    suspend fun getCountries(): Country
}