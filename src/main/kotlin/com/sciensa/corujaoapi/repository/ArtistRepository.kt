package com.sciensa.corujaoapi.repository

import com.sciensa.corujaoapi.domain.ArtistDomain
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository: MongoRepository<ArtistDomain, String> {
}