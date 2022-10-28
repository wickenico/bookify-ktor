package com.nw.dao

import com.nw.dao.DatabaseFactory.dbQuery
import com.nw.models.Book
import com.nw.models.Books
import com.nw.models.Books.id
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

    override suspend fun addNewBook(title: String, author: String, publisher: String, pages: Int): Book? = dbQuery {
        val insertStatement = Books.insert {
            it[Books.title] = title
            it[Books.author] = author
            it[Books.publisher] = publisher
            it[Books.pages] = pages
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToBook)
    }

    override suspend fun editBook(id: Int, title: String, author: String, publisher: String, pages: Int): Boolean = dbQuery {
        Books.update({ Books.id eq id }) {
            it[Books.title] = title
            it[Books.author] = author
            it[Books.publisher] = publisher
            it[Books.pages] = pages
        } > 0
    }

    override suspend fun deleteBook(id: Int): Boolean = dbQuery {
        Books.deleteWhere { Books.id eq id } > 0
    }

    override suspend fun transferBook(id: Int, title: String, author: String, publisher: String, pages: Int): Book? {
        return Book(
            id = id,
            title = title,
            author = author,
            publisher = publisher,
            pages = pages
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
                200
            )
        }
    }
}
