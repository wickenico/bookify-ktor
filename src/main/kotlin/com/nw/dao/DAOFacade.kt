package com.nw.dao

import com.nw.models.Book
import java.time.OffsetDateTime

interface DAOFacade {
    suspend fun allBooks(): List<Book>
    suspend fun book(id: Int): Book?
    suspend fun addNewBook(
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
    ): Book?
    suspend fun editBook(
        id: Int,
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
    ): Boolean
    suspend fun deleteBook(id: Int): Boolean
}
