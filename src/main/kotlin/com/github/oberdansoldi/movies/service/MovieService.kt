package com.github.oberdansoldi.movies.service

import com.github.oberdansoldi.movies.domain.dto.MovieRequest
import com.github.oberdansoldi.movies.domain.dto.MovieResponse
import com.github.oberdansoldi.movies.domain.entity.Movie
import com.github.oberdansoldi.movies.exception.MovieNotFoundException
import com.github.oberdansoldi.movies.repository.MovieRepository
import com.github.oberdansoldi.movies.service.mapper.MovieMapper
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class MovieService(private val movieRepository: MovieRepository, private val movieMapper: MovieMapper) {
    fun create(movieRequest: MovieRequest) {
        movieRepository.save(movieMapper.toEntity(movieRequest))
    }

    fun getAll(): List<MovieResponse> {
        val movies: List<Movie> = movieRepository.findAll()
        return movies.stream().map { movieMapper.toResponse(it) }.toList()
    }

    fun getById(id: Long): MovieResponse {
        return movieRepository.findById(id).map { movieMapper.toResponse(it) }.orElseThrow { MovieNotFoundException() }
    }

    fun update(movieRequest: MovieRequest, id: Long): MovieResponse {
        val sim = movieRepository.findById(id).map { movieMapper.toRequest(it) }
        sim.map {
            it.name = movieRequest.name
            it.rating = movieRequest.rating
            movieRepository.save(movieMapper.toEntity(it))
        }
        return movieRepository.findById(id).map {
            it.name = movieRequest.name
            it.rating = movieRequest.rating
            movieMapper.toResponse(movieRepository.save(it))
        }.orElseThrow { MovieNotFoundException() }
    }

    fun delete(id: Long) {
        movieRepository.findById(id).map { movieRepository.deleteById(id) }.orElseThrow { MovieNotFoundException() }
    }
}