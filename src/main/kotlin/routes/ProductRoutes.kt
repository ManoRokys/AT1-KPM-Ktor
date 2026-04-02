package routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Product
import repository.ProductRepository

fun Route.productRoutes(repository: ProductRepository) {

    route("/products") {

        get {
            call.respond(repository.getAll())
        }

        post {
            val product = call.receive<Product>()
            repository.create(product)
            call.respondText("Produto criado")
        }

        put("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val product = call.receive<Product>()
            repository.update(id, product)
            call.respondText("Produto atualizado")
        }

        delete("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            repository.delete(id)
            call.respondText("Produto deletado")
        }
    }
}