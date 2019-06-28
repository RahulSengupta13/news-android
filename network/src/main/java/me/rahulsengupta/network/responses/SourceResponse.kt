package me.rahulsengupta.network.responses

import java.io.Serializable

data class SourceResponse(
    val status: String,
    val sources: List<Source>
) : Serializable {

    data class Source(
        val id: String,
        val name: String,
        val url: String
    ) : Serializable
}