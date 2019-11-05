package com.sciensa.corujaoapi.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "artist")
data class ArtistDomain (
        @Id
        val id: String? = null,
        var firstName: String = "",
        var lastName: String = "",
        var dateOfBirth: Date? = null,
        @CreatedDate
        val createdAt: Date? = null,
        @LastModifiedDate
        val updatedAt: Date? = null
)