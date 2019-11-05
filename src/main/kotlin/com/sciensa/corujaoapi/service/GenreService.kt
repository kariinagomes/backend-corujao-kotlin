package com.sciensa.corujaoapi.service

import com.sciensa.corujaoapi.domain.GenreDomain
import java.util.*

interface GenreService {
    fun listGenres(page: Int, size: Int, search: String): List<GenreDomain>
    fun addGenre(genreBody: GenreDomain): GenreDomain
    fun getGenre(genreId: String): Optional<GenreDomain>
    fun updateGenre(genreId: String, genreBody: GenreDomain): GenreDomain?
}