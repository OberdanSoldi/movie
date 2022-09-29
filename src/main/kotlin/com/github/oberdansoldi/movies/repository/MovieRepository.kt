package com.github.oberdansoldi.movies.repository

import com.github.oberdansoldi.movies.domain.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {
}