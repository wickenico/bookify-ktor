package com.nw

import com.nw.auth.UserSession
import com.nw.persistence.DatabaseFactory
import com.nw.plugins.configureCors
import com.nw.plugins.configureRouting
import com.nw.plugins.configureSecurity
import com.nw.plugins.configureTemplating
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.Sessions
import io.ktor.server.sessions.cookie

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 3600
        }
    }

    install(Authentication) {
/*
        form("auth-form") {
            userParamName = "username"
            passwordParamName = "password"
            validate { credentials ->
                if (credentials.name == Constants.userName && credentials.password == Constants.password) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
            challenge {
                call.respond(HttpStatusCode.Unauthorized, "Credentials are not valid")
            }
        }
*/

        session<UserSession>("auth-session") {
            validate { session ->
                if (session.name.startsWith("jet")) {
                    session
                } else {
                    null
                }
            }
            challenge {
                call.respondRedirect("/login")
            }
        }
    }

    DatabaseFactory.init()
    configureSecurity()
    // configureSerialization()
    configureTemplating()
    configureRouting()
    configureCors()
}
