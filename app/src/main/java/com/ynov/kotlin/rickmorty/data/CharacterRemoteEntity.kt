package com.ynov.kotlin.rickmorty.data

import io.reactivex.internal.operators.flowable.FlowableSequenceEqual
import java.util.*

data class CharacterRemoteEntity(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val episode: List<String>,
    val image: String

)

data class Origin (
    val name: String,
    val url: String


)

data class Location(
    val name: String,
    val url: String
)
