package com.sciensa.corujaoapi.controller

import com.sciensa.corujaoapi.domain.GenreDomain
import com.sciensa.corujaoapi.service.GenreService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*

@RestController
@RequestMapping(value = ["/v1"])
class GenreController(private val service: GenreService) {

    @GetMapping(value = ["/genres"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listGenres(@RequestParam(required = false, defaultValue = "1") page: Int,
                   @RequestParam(required = false, defaultValue = "10") size: Int,
                   @RequestParam(required = false, defaultValue = "") search: String): ResponseEntity<List<GenreDomain>> {

        return try {

            val genres : List<GenreDomain> = service.listGenres(page, size, search)

            ResponseEntity.status(HttpStatus.OK).body(genres)

        } catch (ex : Exception) {
            println(ex);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }

    @PostMapping(value = ["/genres"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addGenre(@RequestBody genreBody: GenreDomain): ResponseEntity<GenreDomain> {

        if (genreBody.description == "") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        return try {

            val genre = service.addGenre(genreBody)

            ResponseEntity.status(HttpStatus.OK).body(genre)

        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }



   /* fun getGenre(): ResponseEntity<GenreDomain> {
        return null;
    }*/

}