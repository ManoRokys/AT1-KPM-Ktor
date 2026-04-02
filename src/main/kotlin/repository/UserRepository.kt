package repository

import models.User

class UserRepository {

    private val users = mutableListOf<User>()

    fun getAll() = users

    fun getById(id: Int) = users.find { it.id == id }

    fun create(user: User) {
        users.add(user)
    }

    fun update(id: Int, user: User) {
        val index = users.indexOfFirst { it.id == id }
        if (index != -1) users[index] = user
    }

    fun delete(id: Int) {
        users.removeIf { it.id == id }
    }
}