package com.nw.plugins

import com.nw.persistence.UserRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.auth.UserIdPrincipal
import io.ktor.server.auth.authentication
import io.ktor.server.auth.form
import io.ktor.server.response.respond
import kotlinx.coroutines.runBlocking

/*fun Application.configureSecurity() {
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
}*/

fun Application.configureSecurity() {
    val userRepository = UserRepository()

    authentication {
        form("auth-form") {
            userParamName = "username"
            passwordParamName = "password"
            validate { credentials ->
                runBlocking {
                    val user = userRepository.findUserByUsernameAndPassword(credentials.name, credentials.password)
                    user?.let { UserIdPrincipal(it.username) }
                }
            }
            challenge {
                // call.respondRedirect("/login")
                call.respond(HttpStatusCode.Unauthorized, "Credentials are not valid")
            }
        }
    }
}
