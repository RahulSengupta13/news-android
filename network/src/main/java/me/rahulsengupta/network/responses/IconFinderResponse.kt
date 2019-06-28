package me.rahulsengupta.network.responses

import java.io.Serializable

data class IconFinderResponse(
    val url: String,
    val icons: List<Icon>
) : Serializable {

    data class Icon(
        val url: String
    ) : Serializable
}