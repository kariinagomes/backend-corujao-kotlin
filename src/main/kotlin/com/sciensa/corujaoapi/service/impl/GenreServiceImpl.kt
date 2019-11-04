package com.sciensa.corujaoapi.service.impl

import com.sciensa.corujaoapi.domain.GenreDomain
import com.sciensa.corujaoapi.repository.GenreRepository
import com.sciensa.corujaoapi.service.GenreService
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Page
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@Service
class GenreServiceImpl(private val repo: GenreRepository): GenreService {

    override fun listGenres(page: Int, size: Int, search: String): List<GenreDomain> {

        val genres : Page<GenreDomain> = repo.findAll(PageRequest.of(page - 1, size))

        if (search.isNotEmpty()) {

            val genresFiltered = ArrayList<GenreDomain>()

            for (genre in genres.toList()) {
                if (genre.description.toLowerCase().contains(search.toLowerCase())) {
                    genresFiltered.add(genre)
                }
            }

            return genresFiltered
        }

        return genres.toList()
    }

    override fun addGenre(genreBody: GenreDomain): GenreDomain {
        return repo.insert(genreBody)
    }

    override fun getGenre(genreId: String): Optional<GenreDomain> {
        return repo.findById(genreId)
    }

    override fun updateGenre(genreId: String, genreBody: GenreDomain): GenreDomain? {

        if (repo.existsById(genreId)) {
            return repo.save(genreBody)
        }

        return null
    }

}