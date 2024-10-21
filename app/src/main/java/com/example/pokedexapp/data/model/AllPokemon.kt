package com.example.pokedexapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseAllPokemon(

    @SerializedName("count")
    @Expose
    var count: Int,

    @SerializedName("next")
    @Expose
    var next: String? = null,

    @SerializedName("previous")
    @Expose
    var previous: String? = null,

    @SerializedName("results")
    @Expose
    var results: List<ResponsePokemon>
)

data class ResponsePokemon(

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("url")
    @Expose
    val url: String
)