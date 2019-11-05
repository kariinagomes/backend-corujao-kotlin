package com.sciensa.corujaoapi.service.impl

import com.sciensa.corujaoapi.domain.ArtistDomain
import com.sciensa.corujaoapi.repository.ArtistRepository
import com.sciensa.corujaoapi.service.ArtistService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArtistServiceImpl(private val repo: ArtistRepository) : ArtistService {
    override fun listArtists(page: Int, size: Int, search: String): List<ArtistDomain> {
        val artists : Page<ArtistDomain> = repo.findAll(PageRequest.of(page - 1, size))

        if (search.isNotEmpty()) {

            val artistsFiltered = ArrayList<ArtistDomain>()

            for (artist in artists.toList()) {
                if (artist.firstName.toLowerCase().contains(search.toLowerCase())) {
                    artistsFiltered.add(artist)
                }
            }

            return artistsFiltered
        }

        return artists.toList()
    }

    override fun addArtist(artistBody: ArtistDomain): ArtistDomain {
        return repo.insert(artistBody)
    }

    override fun getArtist(artistId: String): Optional<ArtistDomain> {
        return repo.findById(artistId)
    }

    override fun updateArtist(artistId: String, artistBody: ArtistDomain): ArtistDomain? {
        if (repo.existsById(artistId)) {
            val artist: Optional<ArtistDomain> = repo.findById(artistId)

            artist.get().firstName = artistBody.firstName
            artist.get().lastName = artistBody.lastName
            artist.get().dateOfBirth = artistBody.dateOfBirth

            return repo.save(artist.get())
        }

        return null
    }

}