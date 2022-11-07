package com.nw.models

import com.nw.util.offsetDateTime
import org.jetbrains.exposed.sql.Table
import java.time.OffsetDateTime
import java.util.concurrent.atomic.AtomicInteger

data class Book(
    val id: Int,
    val isbn10: String,
    val isbn13: String,
    var title: String,
    var subtitle: String,
    var author: String,
    var publisher: String,
    var pages: Int,
    var imageUrl: String,
    var selfLink: String,
    var publishedDate: OffsetDateTime,
    var description: String,
    var printType: String, // Enum?
    var category: String,
    var maturityRating: String, // Enum?
    var language: String, // Enum?
    var infoLink: String,
    var rating: Int,
    var comment: String,
    var readStatus: String, // Enum?
    var addedOnDate: OffsetDateTime,
    var tags: String
) {
    companion object {
        private val idCounter = AtomicInteger()
        fun newBook(
            isbn10: String,
            isbn13: String,
            title: String,
            subtitle: String,
            author: String,
            publisher: String,
            pages: Int,
            imageUrl: String,
            selfLink: String,
            publishedDate: OffsetDateTime,
            description: String,
            printType: String,
            category: String,
            maturityRating: String,
            language: String,
            infoLink: String,
            rating: Int,
            comment: String,
            readStatus: String,
            addedOnDate: OffsetDateTime,
            tags: String
        ) = Book(
            idCounter.getAndIncrement(),
            isbn10,
            isbn13,
            title,
            subtitle,
            author,
            publisher,
            pages,
            imageUrl,
            selfLink,
            publishedDate,
            description,
            printType,
            category,
            maturityRating,
            language,
            infoLink,
            rating,
            comment,
            readStatus,
            addedOnDate,
            tags
        )
    }
}

object Books : Table() {
    val id = integer("id").autoIncrement()
    val isbn10 = varchar("isbn10", 128)
    val isbn13 = varchar("isbn13", 128)
    val title = varchar("title", 128)
    val subtitle = varchar("subtitle", 128)
    val author = varchar("author", 128)
    val publisher = varchar("publisher", 128)
    val pages = integer("pages")
    val imageUrl = varchar("imageUrl", 128)
    val selfLink = varchar("selfLink", 128)
    val publishedDate = offsetDateTime("publishedDate")
    val description = varchar("description", 999)
    val printType = varchar("printType", 128)
    val category = varchar("category", 128)
    val maturityRating = varchar("maturityRating", 128)
    val language = varchar("language", 128)
    val infoLink = varchar("infoLink", 128)
    val rating = integer("rating")
    val comment = varchar("comment", 128)
    val readStatus = varchar("readStatus", 128)
    val addedOnDate = offsetDateTime("addedOnDate")
    val tags = varchar("tags", 128)

    override val primaryKey = PrimaryKey(id)
}

// val books = mutableListOf(
//    Book.newBook(
//        "It",
//        "Stephen King",
//        "Rororo",
//        200,
//        "http://books.google.com/books/content?id=RXKBrgEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api",
//    )
// )
