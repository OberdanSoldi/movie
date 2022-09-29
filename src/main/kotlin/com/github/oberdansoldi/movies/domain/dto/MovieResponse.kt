package com.github.oberdansoldi.movies.domain.dto

data class MovieResponse(
    val id: Long?,
    var name: String,
    var rating: Double,
)