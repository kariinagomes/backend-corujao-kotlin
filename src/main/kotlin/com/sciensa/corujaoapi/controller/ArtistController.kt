package com.sciensa.corujaoapi.controller

import com.sciensa.corujaoapi.domain.ArtistDomain
import com.sciensa.corujaoapi.service.ArtistService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1")
class ArtistController(private val service: ArtistService) {

    @GetMapping(value = ["/artists"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listArtists(@RequestParam(required = false, defaultValue = "1") page: Int,
                   @RequestParam(required = false, defaultValue = "10") size: Int,
                   @RequestParam(required = false, defaultValue = "") search: String): ResponseEntity<List<ArtistDomain>> {

        return try {

            val artists : List<ArtistDomain> = service.listArtists(page, size, search)

            ResponseEntity.status(HttpStatus.OK).body(artists)

        } catch (ex : Exception) {
            println(ex);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }

    @PostMapping(value = ["/artists"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addArtist(@RequestBody artistBody: ArtistDomain): ResponseEntity<ArtistDomain> {

        if (artistBody.firstName == "") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        return try {

            val artist = service.addArtist(artistBody)

            ResponseEntity.status(HttpStatus.OK).body(artist)

        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }

    @PutMapping(value = ["/artists/{artistId}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateArtist(@PathVariable("artistId") artistId: String, @RequestBody artistBody: ArtistDomain): ResponseEntity<ArtistDomain> {

        if (artistBody.firstName == "") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        return try {
            val artist = service.updateArtist(artistId, artistBody)

            ResponseEntity.status(HttpStatus.OK).body(artist)
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }

    @GetMapping(value = ["/artists/{artistId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGenre(@PathVariable("artistId") artistId: String): ResponseEntity<Optional<ArtistDomain>> {

        return try {
            val artist = service.getArtist(artistId)

            ResponseEntity.status(HttpStatus.OK).body(artist)
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }
}