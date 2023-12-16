package com.solitudeworks.hermes.model

import kotlin.random.Random

data class Gamer(var name: String, var email: String) {

    var birthday: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()) setId()
        }
    var id: String? = null
        // public get is redundant
        private set
    val searchedGames = mutableListOf<Game?>()

    init { // Executed before class's initialization
        if (this.name.isBlank()) throw IllegalArgumentException("Invalid name!")
        this.email = validateEmail()
    }

    constructor(name: String, email: String, birthday: String, user: String) : this(name, email) {
        this.birthday = birthday
        this.user = user

        this.setId()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthday=$birthday, user=$user, id=$id)"
    }

    private fun setId() {
        val number = Random.nextInt(1000)
        val tag = String.format("%04d", number)

        this.id = "$user#$tag"
    }

    private fun validateEmail(): String {
        // Regex
        val regex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        if (regex.matches(email)) return email
        else throw IllegalArgumentException("Invalid email!")
    }

    fun addSearchedGame(game: Game?) {
        searchedGames.add(game)
    }

    companion object { // Simulate a static method
        fun createGamer(): Gamer {
            val gamer = Gamer("lleomeister", "leomeister@gmail.com", "13/02", "lleomeister")
            println("$gamer was created!")
            return gamer
        }
    }

}