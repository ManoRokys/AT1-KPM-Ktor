import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.routing.*
import repository.UserRepository
import repository.ProductRepository
import routes.userRoutes
import routes.productRoutes

fun Application.configureRouting() {

    val userRepository = UserRepository()
    val productRepository = ProductRepository()

    routing {
        userRoutes(userRepository)
        productRoutes(productRepository)

        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
    }
}

