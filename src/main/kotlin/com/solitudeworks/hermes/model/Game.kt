package com.solitudeworks.hermes.model

data class Game(
    val gameTitle: String,
    val gameID: String = "",
    val gameThumb: String
) {

    override fun toString(): String {
        return "gameTitle='$gameTitle'\ngameID='$gameID'\ngameThumb='$gameThumb'\n"
    }

}