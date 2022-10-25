package com.nw.http

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class Request {

    suspend fun sendRequest(isbn: Long) {
        val client = HttpClient(CIO) {
            install(Logging) {
                level = LogLevel.INFO
            }
        }

        // val response: HttpResponse = client.get("https://www.googleapis.com/books/v1/volumes?q=isbn:9783453528420")
        val response: HttpResponse = client.get("https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn")
        println(response.status)

        client.close()
    }
}

val req: Request = Request().apply {
    runBlocking {
        sendRequest(isbn = 9783453528420)
    }
}
