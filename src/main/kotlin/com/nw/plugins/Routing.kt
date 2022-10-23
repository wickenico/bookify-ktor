package com.nw.plugins

import com.nw.dao.dao
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import io.ktor.server.util.getOrFail

fun Application.configureRouting() {
    routing {
        static("/static") {
            resources("files")
        }
        get("/") {
            call.respondRedirect("books")
        }

        route("search") {
            get {
                call.respond(FreeMarkerContent("search.ftl", model = null))
            }
        }

        route("books") {
            get {
                call.respond(FreeMarkerContent("index.ftl", mapOf("books" to dao.allBooks())))
            }
            get("new") {
                call.respond(FreeMarkerContent("new.ftl", model = null))
            }
            post {
                val formParameters = call.receiveParameters()
                val title = formParameters.getOrFail("title")
                val author = formParameters.getOrFail("author")
                val publisher = formParameters.getOrFail("publisher")
                val pages = formParameters.getOrFail("pages").toInt()
                val book = dao.addNewBook(title, author, publisher, pages)
                call.respondRedirect("/books/${book?.id}")
            }
            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("show.ftl", mapOf("book" to dao.book(id))))
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("edit.ftl", mapOf("book" to dao.book(id))))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val title = formParameters.getOrFail("title")
                        val author = formParameters.getOrFail("author")
                        val publisher = formParameters.getOrFail("publisher")
                        val pages = formParameters.getOrFail("pages").toInt()
                        dao.editBook(id, title, author, publisher, pages)
                        call.respondRedirect("/books/$id")
                    }
                    "delete" -> {
                        dao.deleteBook(id)
                        call.respondRedirect("/books")
                    }
                }
            }
        }
    }
}
