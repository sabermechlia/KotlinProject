package com.ynov.kotlin.rickmorty.model

import com.ynov.kotlin.rickmorty.data.Location
import com.ynov.kotlin.rickmorty.data.Origin

data class RMCharacter(
    val id: String?,
    val name: String,
    val status: String?,
    val species: String?,
    val type: String,
    val gender: String?,
    val origin: Origin?,
    val location: Location?,
    val episode: List<String>?,
    val image: String

)
