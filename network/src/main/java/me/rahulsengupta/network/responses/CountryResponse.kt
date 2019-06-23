package me.rahulsengupta.network.responses

import java.io.Serializable

data class CountryResponse(
    val name: String,
    val alpha2Code: String,
    val alpha3Code: String,
    val flag: String
) : Serializable
