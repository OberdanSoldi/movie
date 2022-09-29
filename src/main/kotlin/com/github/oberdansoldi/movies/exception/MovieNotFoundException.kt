package com.github.oberdansoldi.movies.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class MovieNotFoundException: Exception("Movie not found") {
}