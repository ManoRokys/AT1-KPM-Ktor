package database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert

object DatabaseFactory {

    fun init() {
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/ktor_db",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "postgres"
        )

        transaction {
            SchemaUtils.create(UsersTable)

            // seed simples (evita duplicar sempre)
            if (UsersTable.selectAll().empty()) {
                UsersTable.insert {
                    it[name] = "Lucas"
                    it[email] = "lucas@email.com"
                }
            }
        }
    }
}