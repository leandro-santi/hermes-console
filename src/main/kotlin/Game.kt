class Game(val gameTitle: String, val gameImage: String = "", val gameDescription: String) {

    override fun toString(): String {
        return "Game(gameTitle='$gameTitle', gameImage='$gameImage', gameDescription='$gameDescription')"
    }

}