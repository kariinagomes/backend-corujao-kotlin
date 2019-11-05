package com.sciensa.corujaoapi.service

import com.sciensa.corujaoapi.domain.ArtistDomain
import java.util.*

interface ArtistService {
    fun listArtists(page: Int, size: Int, search: String): List<ArtistDomain>
    fun addArtist(artistBody: ArtistDomain): ArtistDomain
    fun getArtist(artistId: String): Optional<ArtistDomain>
    fun updateArtist(artistId: String, artistBody: ArtistDomain): ArtistDomain?
}