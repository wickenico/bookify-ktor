package com.nw.models

import org.jetbrains.exposed.sql.Table
import java.util.concurrent.atomic.AtomicInteger

data class Book(
    val id: Int,
    var title: String,
    var author: String,
    var publisher: String,
    var pages: Int,
    var imageUrl: String
) {
    companion object {
        private val idCounter = AtomicInteger()
        fun newBook(title: String, author: String, publisher: String, pages: Int, imageUrl: String) = Book(
            idCounter.getAndIncrement(),
            title,
            author,
            publisher,
            pages,
            imageUrl
        )
    }
}

object Books : Table() {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 128)
    val author = varchar("author", 128)
    val publisher = varchar("publisher", 128)
    val pages = integer("pages")
    val imageUrl = varchar("imageUrl", 256)

    override val primaryKey = PrimaryKey(id)
}

val books = mutableListOf(
    Book.newBook(
        "It",
        "Stephen King",
        "Rororo",
        200,
        "nicowickersheim.dev"
    )
)
