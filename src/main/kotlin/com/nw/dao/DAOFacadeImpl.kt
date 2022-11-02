package com.nw.dao

import com.nw.dao.DatabaseFactory.dbQuery
import com.nw.models.Book
import com.nw.models.Books
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class DAOFacadeImpl : DAOFacade {

    private fun resultRowToBook(row: ResultRow) = Book(
        id = row[Books.id],
        title = row[Books.title],
        author = row[Books.author],
        publisher = row[Books.publisher],
        pages = row[Books.pages],
        imageUrl = row[Books.imageUrl]
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

    override suspend fun addNewBook(title: String, author: String, publisher: String, pages: Int, imageUrl: String): Book? = dbQuery {
        val insertStatement = Books.insert {
            it[Books.title] = title
            it[Books.author] = author
            it[Books.publisher] = publisher
            it[Books.pages] = pages
            it[Books.imageUrl] = imageUrl
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToBook)
    }

    override suspend fun editBook(id: Int, title: String, author: String, publisher: String, pages: Int, imageUrl: String): Boolean = dbQuery {
        Books.update({ Books.id eq id }) {
            it[Books.title] = title
            it[Books.author] = author
            it[Books.publisher] = publisher
            it[Books.pages] = pages
            it[Books.imageUrl] = imageUrl
        } > 0
    }

    override suspend fun deleteBook(id: Int): Boolean = dbQuery {
        Books.deleteWhere { Books.id eq id } > 0
    }

    override suspend fun transferBook(id: Int, title: String, author: String, publisher: String, pages: Int, imageUrl: String): Book? {
        return Book(
            id = id,
            title = title,
            author = author,
            publisher = publisher,
            pages = pages,
            imageUrl = imageUrl
        )
    }
}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {
        if (allBooks().isEmpty()) {
            addNewBook(
                "It",
                "Stephen King",
                "Rororo",
                200,
                "http://books.google.com/books/content?id=RXKBrgEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
            )
        }
    }
}
