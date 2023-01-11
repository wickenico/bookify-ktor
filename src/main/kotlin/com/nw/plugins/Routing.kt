package com.nw.plugins

import com.nw.auth.UserSession
import com.nw.enums.PrintTypeEnum
import com.nw.enums.RatingEnum
import com.nw.enums.ReadStatusEnum
import com.nw.persistence.bookFacade
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.UserIdPrincipal
import io.ktor.server.auth.authenticate
import io.ktor.server.auth.principal
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.html.respondHtml
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set
import io.ktor.server.util.getOrFail
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.passwordInput
import kotlinx.html.style
import kotlinx.html.submitInput
import kotlinx.html.textInput
import kotlinx.html.unsafe
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import java.time.OffsetDateTime

fun Application.configureRouting() {
    routing {
        static("/static") {
            resources("files")
        }

        get("/") {
            call.respondRedirect("home")
        }

        /*route("home") {
            get {
                // val userSession = call.principal<UserSession>()
                // val name = userSession?.name
                // println("name = $name")
                // call.respond(FreeMarkerContent("home.ftl", mapOf("user" to mapOf("name" to name))))
                call.respond(FreeMarkerContent("home.ftl", model = null))
            }
        }*/

        route("login") {
            get {
                // call.respond(FreeMarkerContent("login.ftl", model = null))
                call.respondHtml {
                    head {
                        style {
                            unsafe {
                                +"""
              .container {
                height: 100vh;
                width: 100vw;
                display: flex;
                align-items: center;
                justify-content: center;
              }
              form {
                text-align: center;
              }
            """
                            }
                        }
                    }
                    body {
                        div("container") {
                            form(
                                action = "/login",
                                encType = FormEncType.applicationXWwwFormUrlEncoded,
                                method = FormMethod.post
                            ) {
                                p {
                                    +"Username:"
                                    textInput(name = "username")
                                }
                                p {
                                    +"Password:"
                                    passwordInput(name = "password")
                                }
                                p {
                                    submitInput() { value = "Login" }
                                }
                            }
                        }
                    }
                }
            }
        }

        authenticate("auth-form") {
            post("/login") {
                val userName = call.principal<UserIdPrincipal>()?.name.toString()
                println("userName = $userName")
                call.sessions.set(UserSession(name = userName))
                call.respondRedirect("/home")
            }
        }

        authenticate("auth-session") {
            get("/home") {
                val userSession = call.principal<UserSession>()
                val name = userSession?.name
                call.respond(FreeMarkerContent("home.ftl", mapOf("user" to mapOf("name" to name))))
            }
        }

        get("/logout") {
            call.sessions.clear<UserSession>()
            call.respondRedirect("/login")
        }

        route("changelog") {
            get {
                call.respond(FreeMarkerContent("changelog.ftl", model = null))
            }
        }

        route("error") {
            get {
                call.respond(FreeMarkerContent("error.ftl", model = null))
            }
        }

        route("books") {
            get {
                call.respond(FreeMarkerContent("index.ftl", mapOf("books" to bookFacade.allBooks())))
            }
            get("new") {
                call.respond(FreeMarkerContent("new.ftl", model = null))
            }
            post {
                val formParameters = call.receiveParameters()
                val isbn10 = formParameters.getOrFail("isbn10")
                val isbn13 = formParameters.getOrFail("isbn13")

                val title = formParameters.getOrFail("title")
                val subtitle = formParameters.getOrFail("subtitle")
                val author = formParameters.getOrFail("author")
                val publisher = formParameters.getOrFail("publisher")
                val pages = formParameters.getOrFail("pages").toInt()
                val imageUrl = formParameters.getOrFail("imageUrl")
                val selfLink = formParameters.getOrFail("selfLink")
                val publishedDate = formParameters.getOrFail("publishedDate")
                val publishedDateFormatted = OffsetDateTime.parse(publishedDate)
                val description = formParameters.getOrFail("description")
                val printType = formParameters.getOrFail("printType")
                val category = formParameters.getOrFail("category")
                val maturityRating = formParameters.getOrFail("maturityRating")
                val language = formParameters.getOrFail("language")
                val infoLink = formParameters.getOrFail("infoLink")
                val rating = formParameters.getOrFail("rating").toInt()
                val comment = formParameters.getOrFail("comment")
                val readStatus = formParameters.getOrFail("readStatus")
                val addedOnDate = formParameters.getOrFail("addedOnDate")
                val addedOnDateFormatted = OffsetDateTime.parse(addedOnDate)
                val tags = formParameters.getOrFail("tags")
                val book = bookFacade.addNewBook(
                    isbn10,
                    isbn13,
                    title,
                    subtitle,
                    author,
                    publisher,
                    pages,
                    imageUrl,
                    selfLink,
                    publishedDateFormatted,
                    description,
                    PrintTypeEnum.valueOf(printType),
                    category,
                    maturityRating,
                    language,
                    infoLink,
                    RatingEnum.getByValue(rating),
                    comment,
                    ReadStatusEnum.valueOf(readStatus),
                    addedOnDateFormatted,
                    tags
                )

                call.respondRedirect("/books/${book?.id}")
            }
            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("show.ftl", mapOf("book" to bookFacade.book(id))))
            }
            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("edit.ftl", mapOf("book" to bookFacade.book(id))))
            }
            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "update" -> {
                        val isbn10 = formParameters.getOrFail("isbn10")
                        val isbn13 = formParameters.getOrFail("isbn13")
                        val title = formParameters.getOrFail("title")
                        val subtitle = formParameters.getOrFail("subtitle")
                        val author = formParameters.getOrFail("author")
                        val publisher = formParameters.getOrFail("publisher")
                        val pages = formParameters.getOrFail("pages").toInt()
                        val imageUrl = formParameters.getOrFail("imageUrl")
                        val selfLink = formParameters.getOrFail("selfLink")
                        // val publishedDate = formParameters.getOrFail("publishedDate")
                        // val publishedDateFormatted = OffsetDateTime.parse(publishedDate)
                        val description = formParameters.getOrFail("description")
                        val printType = formParameters.getOrFail("printType")
                        val category = formParameters.getOrFail("category")
                        val maturityRating = formParameters.getOrFail("maturityRating")
                        val language = formParameters.getOrFail("language")
                        val infoLink = formParameters.getOrFail("infoLink")
                        val rating = formParameters.getOrFail("rating").toInt()
                        val comment = formParameters.getOrFail("comment")
                        val readStatus = formParameters.getOrFail("readStatus")
                        // val addedOnDate = formParameters.getOrFail("addedOnDate")
                        // val addedOnDateFormatted = OffsetDateTime.parse(addedOnDate)
                        val tags = formParameters.getOrFail("tags")
                        bookFacade.editBook(
                            id,
                            isbn10,
                            isbn13,
                            title,
                            subtitle,
                            author,
                            publisher,
                            pages,
                            imageUrl,
                            selfLink,
                            OffsetDateTime.now(),
                            description,
                            PrintTypeEnum.valueOf(printType),
                            category,
                            maturityRating,
                            language,
                            infoLink,
                            RatingEnum.getByValue(rating),
                            comment,
                            ReadStatusEnum.valueOf(readStatus),
                            OffsetDateTime.now(),
                            tags
                        )
                        call.respondRedirect("/books/$id")
                    }

                    "delete" -> {
                        bookFacade.deleteBook(id)
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
                    expectSuccess = true
                    install(ContentNegotiation) {
                        json(
                            Json {
                                prettyPrint = true
                                isLenient = true
                            }
                        )
                    }
                }
                val response: HttpResponse =
                    client.get("https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn&country=DE&maxResults=2")
                println(response.status)
                val stringBody: String = response.body()

                val json: Map<String, JsonElement> = Json.parseToJsonElement(stringBody).jsonObject

                if (json["items"] == null) {
                    client.close()
                    call.respondRedirect("/error")
                }

                val items = json["items"]!!.jsonArray

                val item = items[0]

                val itemInfo = item.jsonObject

                val volumeInfo = itemInfo["volumeInfo"]

                val volumeInfoObject = volumeInfo?.jsonObject

                // ISBN
                var isbnArray = volumeInfoObject?.get("industryIdentifiers")?.jsonArray

                var isbn10Object = isbnArray?.get(0)?.jsonObject
                var isbn10 = isbn10Object?.get("identifier").toString()
                isbn10 = isbn10.replace("\"", "").trim()

                var isbn13: String

                if ((isbnArray?.size ?: 0) > 1) {
                    var isbn13Object = isbnArray?.get(1)?.jsonObject
                    isbn13 = isbn13Object?.get("identifier").toString()
                    isbn13 = isbn13.replace("\"", "").trim()
                } else {
                    isbn13 = isbn10
                }

                if (bookFacade.findBookByIsbn10orIsbn13(isbn10, isbn13) != null) {
                    val status = HttpStatusCode.Conflict
                    val message = "The book $isbn10 / $isbn13 already exists."
                    call.respond(status, FreeMarkerContent("error.ftl", mapOf("status" to mapOf("code" to status.value, "message" to message))))
                } else {

                    // Title
                    var title = volumeInfoObject?.get("title").toString()
                    title = title.replace("\"", "")

                    // Subtitle
                    var subtitle = volumeInfoObject?.get("subtitle").toString()
                    subtitle = subtitle.replace("\"", "")

                    // Author
                    val authors = volumeInfoObject?.get("authors")?.jsonArray

                    var author = authors?.get(0).toString()
                    author = author.replace("\"", "")

                    // Publisher
                    var publisher = volumeInfoObject?.get("publisher").toString()
                    publisher = publisher.replace("\"", "")

                    // Pages
                    var pageCount = volumeInfoObject?.get("pageCount")
                    var pages = pageCount.toString().toInt()

                    // Cover Image
                    val imageLinks = volumeInfoObject?.get("imageLinks")?.jsonObject

                    var imageUrl = imageLinks?.get("thumbnail").toString()
                    imageUrl = imageUrl.replace("\"", "").trim()

                    // Self Link
                    var selfLink = itemInfo["selfLink"].toString()
                    selfLink = selfLink.replace("\"", "").trim()

                    // Published Date
                    // var publishedDate = volumeInfoObject?.get("publishedDate").toString()
                    var pDate = OffsetDateTime.now()

                    // Description
                    var description = volumeInfoObject?.get("description").toString()
                    description = description.replace("\"", "")

                    // Print Type
                    var printType = volumeInfoObject?.get("printType").toString()
                    printType = printType.replace("\"", "")

                    // Category
                    var category = ""

                    // Maturity Rating
                    var maturityRating = volumeInfoObject?.get("maturityRating").toString()
                    maturityRating = maturityRating.replace("\"", "")

                    // Language
                    var language = volumeInfoObject?.get("language").toString()
                    language = language.replace("\"", "")

                    // Info Link
                    var infoLink = volumeInfoObject?.get("infoLink").toString()
                    infoLink = infoLink.replace("\"", "")

                    // Rating
                    var rating = 0

                    // Comment
                    var comment = ""

                    // Read Status
                    var readStatus = "UNREAD"

                    // Added On Date
                    var addedOnDate = OffsetDateTime.now()

                    // Tags
                    var tags = ""

                    client.close()
                    val book = bookFacade.addNewBook(
                        isbn10,
                        isbn13,
                        title,
                        subtitle,
                        author,
                        publisher,
                        pages,
                        imageUrl,
                        selfLink,
                        pDate,
                        description,
                        PrintTypeEnum.getByValue(printType),
                        category,
                        maturityRating,
                        language,
                        infoLink,
                        RatingEnum.getByValue(rating),
                        comment,
                        ReadStatusEnum.getByValue(readStatus),
                        addedOnDate,
                        tags
                    )
                    call.respondRedirect("/search/found/${book?.id}")
                }
            }

            // 9783453528420
            // 9783866471764

            get("found/{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("edit.ftl", mapOf("book" to bookFacade.book(id))))
            }
        }
    }
}
