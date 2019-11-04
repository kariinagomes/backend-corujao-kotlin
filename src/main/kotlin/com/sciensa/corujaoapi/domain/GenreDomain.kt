package com.sciensa.corujaoapi.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "genre")
data class GenreDomain(
        @Id
        val id: ObjectId? = null,
        val description: String = "",
        @CreatedDate
        val createdAt: Date? = null,
        @LastModifiedBy
        val updatedAt: Date? = null
)