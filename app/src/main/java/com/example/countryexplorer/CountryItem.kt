package com.example.countryexplorer

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryItem(
    @SerializedName("name")
    val name: Name,
    @SerializedName("capital")
    val capital: List<String>?,
    @SerializedName("region")
    val region: String,
    @SerializedName("population")
    val population: Long,
    @SerializedName("area")
    val area: Double?,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("currencies")
    val currencies: Map<String, Currency>?,
    @SerializedName("languages")
    val languages: Map<String, String>?
) : Serializable

data class Name(
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String
) : Serializable

data class Flags(
    @SerializedName("png")
    val png: String
) : Serializable

data class Currency(
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
) : Serializable
