package com.nw.plugins

import com.nw.const.Constants
import io.ktor.server.application.Application
import io.ktor.server.auth.UserIdPrincipal
import io.ktor.server.auth.authentication
import io.ktor.server.auth.form
import io.ktor.server.response.respondRedirect

fun Application.configureSecurity() {
    authentication {
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
                call.respondRedirect("/login")
                // call.respond(HttpStatusCode.Unauthorized, "Credentials are not valid")
            }
        }
    }
}
