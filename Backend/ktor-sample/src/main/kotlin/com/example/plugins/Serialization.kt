package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.serialization.*
import org.slf4j.event.Level

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}