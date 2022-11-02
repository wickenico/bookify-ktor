package com.nw.dao

import com.nw.models.Book

interface DAOFacade {
    suspend fun allBooks(): List<Book>
    suspend fun book(id: Int): Book?
    suspend fun addNewBook(title: String, author: String, publisher: String, pages: Int, imageUrl: String): Book?
    suspend fun editBook(id: Int, title: String, author: String, publisher: String, pages: Int, imageUrl: String): Boolean
    suspend fun deleteBook(id: Int): Boolean
    suspend fun transferBook(id: Int, title: String, author: String, publisher: String, pages: Int, imageUrl: String): Book?
}
