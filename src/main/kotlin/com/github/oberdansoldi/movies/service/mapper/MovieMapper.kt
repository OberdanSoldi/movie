package com.github.oberdansoldi.movies.service.mapper

import com.github.oberdansoldi.movies.domain.dto.MovieRequest
import com.github.oberdansoldi.movies.domain.dto.MovieResponse
import com.github.oberdansoldi.movies.domain.entity.Movie
import org.springframework.stereotype.Component

@Component
class MovieMapper {
    fun toEntity(movieRequest: MovieRequest): Movie {
        return Movie(
            name = movieRequest.name,
            rating = movieRequest.rating
        )
    }

    fun toRequest(movie: Movie): MovieRequest {
        return MovieRequest(
            name = movie.name,
            rating = movie.rating
        )
    }

    fun toResponse(movie: Movie): MovieResponse {
        return MovieResponse(
            id = movie.id,
            name = movie.name,
            rating = movie.rating
        )
    }

}