package com.nw

import com.nw.persistence.DatabaseFactory
import com.nw.plugins.configureRouting
import com.nw.plugins.configureTemplating
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    DatabaseFactory.init()
    // configureSerialization()
    configureTemplating()
    configureRouting()

    install(StatusPages) {
    }
}
