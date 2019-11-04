package com.sciensa.corujaoapi.repository

import com.sciensa.corujaoapi.domain.GenreDomain
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : MongoRepository<GenreDomain, String> {
}