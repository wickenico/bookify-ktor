package com.nw.plugins

import com.nw.dao.dao
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
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
import io.ktor.util.InternalAPI
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

@OptIn(InternalAPI::class)
fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("files")
        }
        get("/") {
            call.respondRedirect("books")
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
                val imageUrl = formParameters.getOrFail("imageUrl")
                val book = dao.addNewBook(title, author, publisher, pages, imageUrl)
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
                        val imageUrl = formParameters.getOrFail("imageUrl")
                        dao.editBook(id, title, author, publisher, pages, imageUrl)
                        call.respondRedirect("/books/$id")
                    }
                    "delete" -> {
                        dao.deleteBook(id)
                        call.respondRedirect("/books")
                    }
                }
            }
        }

        route("search") {
            get {
                call.respond(FreeMarkerContent("search.ftl", model = null))
            }

            get("field") {
                val isbn = call.request.queryParameters.getOrFail("isbn").toLong()
                val client = HttpClient(CIO) {
                    install(ContentNegotiation) {
                        json(
                            Json {
                                prettyPrint = true
                                isLenient = true
                            }
                        )
                    }
                }
                val response: HttpResponse = client.get("https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn")
                println(response.status)
                val stringBody: String = response.body()

                val json: Map<String, JsonElement> = Json.parseToJsonElement(stringBody).jsonObject
                // println(json)
                val items = json["items"]!!.jsonArray
                // println("items: $items")
                val item = items[0]
                // println("a: $a")
                val itemInfo = item.jsonObject
                println("b: $itemInfo")
                val volumeInfo = itemInfo["volumeInfo"]
                println("volumeInfo: $volumeInfo")

                val volumeInfoObject = volumeInfo?.jsonObject
                println("c: $volumeInfoObject")

                var title = volumeInfoObject?.get("title").toString()
                println("d: $title")
                title = title.replace("\"", "")

                val authors = volumeInfoObject?.get("authors")?.jsonArray
                println("authors: $authors")

                var author = authors?.get(0).toString()
                println("author: $author")
                author = author.replace("\"", "")

                var publisher = volumeInfoObject?.get("publisher").toString()
                println("publisher: $publisher")
                publisher = publisher.replace("\"", "")

                var pageCount = volumeInfoObject?.get("pageCount")
                println("pageCount: $pageCount")

                var pages = pageCount.toString().toInt()
                println("pages: $pages")

                val imageLinks = volumeInfoObject?.get("imageLinks")?.jsonObject
                println("imageLinks: $imageLinks")

                var imageUrl = imageLinks?.get("thumbnail").toString()
                imageUrl = imageUrl.replace("\"", "").trim()
                println("imageUrl: $imageUrl")

                client.close()
                val book = dao.addNewBook(title, author, publisher, pages, imageUrl)
                call.respondRedirect("/search/found/${book?.id}")
            }

            // 9783453528420
            // 9783866471764

            get("found/{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("edit.ftl", mapOf("book" to dao.book(id))))
            }
        }
    }
}
