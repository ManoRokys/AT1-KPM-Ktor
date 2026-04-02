package routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.User
import repository.UserRepository

fun Route.userRoutes(repository: UserRepository) {

    route("/users") {

        get {
            call.respond(repository.getAll())
        }

        post {
            val user = call.receive<User>()
            repository.create(user)
            call.respondText("User criado")
        }

        put("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val user = call.receive<User>()
            repository.update(id, user)
            call.respondText("User atualizado")
        }

        delete("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            repository.delete(id)
            call.respondText("User deletado")
        }
    }
}