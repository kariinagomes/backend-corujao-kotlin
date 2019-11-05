package com.sciensa.corujaoapi.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "genre")
data class GenreDomain(
        @Id
        var id: String? = null,
        var description: String = "",
        @CreatedDate
        val createdAt: Date? = null,
        @LastModifiedDate
        val updatedAt: Date? = null
)