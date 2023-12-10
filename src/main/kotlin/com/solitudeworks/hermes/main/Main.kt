package com.solitudeworks.hermes.main

import com.solitudeworks.hermes.model.Game
import com.solitudeworks.hermes.service.RequestApi
import java.util.*

/*

    API consume using Java HTTPClient lib from Oracle Java SDK Docs

*/

fun main() {

    val scanner = Scanner(System.`in`) // Read id

    println("Enter a game id to search:")
    val search = scanner.nextLine()

    val request = RequestApi()
    val answer = request.search(search)

    val result = runCatching {
        val game = Game(answer.gameInfo.title, answer.gameInfo.steamAppID, answer.gameInfo.thumb)

        println(game)
    }

    result.onSuccess {
        println("Success on search!")
    }
    result.onFailure {
        println("Error on search!")
    }

}