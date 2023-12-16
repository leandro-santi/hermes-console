package com.solitudeworks.hermes.main

import com.solitudeworks.hermes.model.Game
import com.solitudeworks.hermes.model.Gamer
import com.solitudeworks.hermes.service.RequestApi
import java.util.*

/*

    API consume using Java HTTPClient lib from Oracle Java SDK Docs

*/

fun main() {

    val scanner = Scanner(System.`in`) // Read id

    val gamer = Gamer.createGamer()

    do {
        println("\nEnter a game id to search: (or -1 to EXIT)")
        val search = scanner.nextLine()

        if (search.equals("-1")) break

        val request = RequestApi()
        val answer = request.search(search)
        var game: Game? = null

        val result = runCatching {
            game = Game(answer.gameInfo.title, answer.gameInfo.steamAppID, answer.gameInfo.thumb)

            // println(game)
        }

        result.onSuccess {
            println("Success on search!")
            gamer.addSearchedGame(game)
        }
        result.onFailure {
            println("Error on search!")
        }
    } while (search != "-1")

    println("The search is finished!")

    println("Searched Games:")
    for (item in gamer.searchedGames) {
        println(item.toString())
    }

    gamer.searchedGames.sortBy {
        it?.gameTitle
    }

    gamer.searchedGames.forEach {
        println(it?.gameTitle)
    }

}