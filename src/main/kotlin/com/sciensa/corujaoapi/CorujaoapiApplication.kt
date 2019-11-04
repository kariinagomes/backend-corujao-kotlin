package com.sciensa.corujaoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@EnableMongoAuditing
@SpringBootApplication
class CorujaoapiApplication

fun main(args: Array<String>) {
	runApplication<CorujaoapiApplication>(*args)
}
