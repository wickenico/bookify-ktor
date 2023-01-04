package com.nw.persistence

import com.nw.models.Books
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        // val driverClassName = "org.h2.Driver"
        val driverClassName = "com.mysql.cj.jdbc.Driver"
        // val jdbcURL = "jdbc:h2:file:./build/db"
        val jdbcURL = "jdbc:mysql://ltnya0pnki2ck9w8.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/qrv3uy14jid19xxt"
        val user = "aal48kjwfhysb1uw"
        val password = "mnvwgrfvt73s2hji"
        val database = Database.connect(jdbcURL, driverClassName, user, password)
        transaction(database) {
            SchemaUtils.create(Books)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
