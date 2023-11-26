class Game {

    var gameTitle: String = "" // Explicit
    var gameImage = ""
    var gameDescription = "" // Implicit

    override fun toString(): String {
        return "Game(gameTitle='$gameTitle', gameImage='$gameImage', gameDescription='$gameDescription')"
    }

}