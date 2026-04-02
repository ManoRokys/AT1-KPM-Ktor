package repository

import models.Product

class ProductRepository {

    private val products = mutableListOf<Product>()

    fun getAll() = products

    fun getById(id: Int) = products.find { it.id == id }

    fun create(product: Product) {
        products.add(product)
    }

    fun update(id: Int, product: Product) {
        val index = products.indexOfFirst { it.id == id }
        if (index != -1) products[index] = product
    }

    fun delete(id: Int) {
        products.removeIf { it.id == id }
    }
}