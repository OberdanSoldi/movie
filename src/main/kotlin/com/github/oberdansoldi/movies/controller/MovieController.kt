package com.github.oberdansoldi.movies.controller

import com.github.oberdansoldi.movies.domain.dto.MovieRequest
import com.github.oberdansoldi.movies.domain.dto.MovieResponse
import com.github.oberdansoldi.movies.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/movie")
class MovieController(private val movieService: MovieService) {
    @GetMapping
    fun getAll(): ResponseEntity<List<MovieResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAll().toList())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<MovieResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getById(id))
    }

    @PostMapping
    fun create(@RequestBody movieRequest: MovieRequest): ResponseEntity<HttpStatus> {
        movieService.create(movieRequest)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody movieRequest: MovieRequest): ResponseEntity<MovieResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.update(movieRequest, id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<HttpStatus> {
        movieService.delete(id)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

}