package com.lucasgf

import configureRouting
import database.DatabaseFactory
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    DatabaseFactory.init()

    configureSerialization()
    configureHTTP()
    configureMonitoring()
    configureRouting()
}
