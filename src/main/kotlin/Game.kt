data class Game(
    private val gameTitle: String,
    private val gameID: String = "",
    private val gameThumb: String
) {

    override fun toString(): String {
        return "gameTitle='$gameTitle'\ngameID='$gameID'\ngameThumb='$gameThumb'"
    }

}