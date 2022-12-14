package com.nw.persistence

import com.nw.enums.PrintTypeEnum
import com.nw.enums.RatingEnum
import com.nw.enums.ReadStatusEnum
import com.nw.models.Book
import com.nw.models.Books
import com.nw.persistence.DatabaseFactory.dbQuery
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.orWhere
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update
import java.time.OffsetDateTime

class BookRepository : BookFacade {

    private fun resultRowToBook(row: ResultRow) = Book(
        id = row[Books.id],
        isbn10 = row[Books.isbn10],
        isbn13 = row[Books.isbn13],
        title = row[Books.title],
        subtitle = row[Books.subtitle],
        author = row[Books.author],
        publisher = row[Books.publisher],
        pages = row[Books.pages],
        imageUrl = row[Books.imageUrl],
        selfLink = row[Books.selfLink],
        publishedDate = row[Books.publishedDate],
        description = row[Books.description],
        printType = row[Books.printType],
        category = row[Books.category],
        maturityRating = row[Books.maturityRating],
        language = row[Books.language],
        infoLink = row[Books.infoLink],
        rating = row[Books.rating],
        comment = row[Books.comment],
        readStatus = row[Books.readStatus],
        addedOnDate = row[Books.addedOnDate],
        tags = row[Books.tags],
    )

    override suspend fun allBooks(): List<Book> = dbQuery {
        Books.selectAll().map(::resultRowToBook)
    }

    override suspend fun book(id: Int): Book? = dbQuery {
        Books
            .select { Books.id eq id }
            .map(::resultRowToBook)
            .singleOrNull()
    }

    override suspend fun findBookByIsbn10orIsbn13(isbn10: String, isbn13: String): Book? = dbQuery {
        Books.select { Books.isbn10 eq isbn10 }
            .orWhere { Books.isbn13 eq isbn13 }
            .map(::resultRowToBook)
            .singleOrNull()
    }

    override suspend fun addNewBook(
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
        printType: PrintTypeEnum,
        category: String,
        maturityRating: String,
        language: String,
        infoLink: String,
        rating: RatingEnum,
        comment: String,
        readStatus: ReadStatusEnum,
        addedOnDate: OffsetDateTime,
        tags: String
    ): Book? = dbQuery {
        val insertStatement = Books.insert {
            it[Books.isbn10] = isbn10
            it[Books.isbn13] = isbn13
            it[Books.title] = title
            it[Books.subtitle] = subtitle
            it[Books.author] = author
            it[Books.publisher] = publisher
            it[Books.pages] = pages
            it[Books.imageUrl] = imageUrl
            it[Books.selfLink] = selfLink
            it[Books.publishedDate] = publishedDate
            it[Books.description] = description
            it[Books.printType] = PrintTypeEnum.getByValue(printType.type)
            it[Books.category] = category
            it[Books.maturityRating] = maturityRating
            it[Books.language] = language
            it[Books.infoLink] = infoLink
            it[Books.rating] = RatingEnum.getByValue(rating.rating)
            it[Books.comment] = comment
            it[Books.readStatus] = ReadStatusEnum.getByValue(readStatus.status)
            it[Books.addedOnDate] = addedOnDate
            it[Books.tags] = tags
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToBook)
    }

    override suspend fun editBook(
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
        printType: PrintTypeEnum,
        category: String,
        maturityRating: String,
        language: String,
        infoLink: String,
        rating: RatingEnum,
        comment: String,
        readStatus: ReadStatusEnum,
        addedOnDate: OffsetDateTime,
        tags: String
    ): Boolean = dbQuery {
        Books.update({ Books.id eq id }) {
            it[Books.isbn10] = isbn10
            it[Books.isbn13] = isbn13
            it[Books.title] = title
            it[Books.subtitle] = subtitle
            it[Books.author] = author
            it[Books.publisher] = publisher
            it[Books.pages] = pages
            it[Books.imageUrl] = imageUrl
            it[Books.selfLink] = selfLink
            it[Books.publishedDate] = publishedDate
            it[Books.description] = description
            it[Books.printType] = PrintTypeEnum.getByValue(printType.type)
            it[Books.category] = category
            it[Books.maturityRating] = maturityRating
            it[Books.language] = language
            it[Books.infoLink] = infoLink
            it[Books.rating] = RatingEnum.getByValue(rating.rating)
            it[Books.comment] = comment
            it[Books.readStatus] = ReadStatusEnum.getByValue(readStatus.status)
            it[Books.addedOnDate] = addedOnDate
            it[Books.tags] = tags
        } > 0
    }

    override suspend fun deleteBook(id: Int): Boolean = dbQuery {
        Books.deleteWhere { Books.id eq id } > 0
    }
}

val bookFacade: BookFacade = BookRepository().apply {
    runBlocking {
        if (allBooks().isEmpty()) {
//            addNewBook(
//                "It",
//                "Stephen King",
//                "Rororo",
//                200,
//                "http://books.google.com/books/content?id=RXKBrgEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
//            )
        }
    }
}
