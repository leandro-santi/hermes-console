import com.google.gson.annotations.SerializedName

class Game(
    @SerializedName("title") private val gameTitle: String,
    @SerializedName("steamAppID") private val gameImage: String = "",
    @SerializedName("thumb") private val gameDescription: String
) {

    override fun toString(): String {
        return "Game(gameTitle='$gameTitle', gameImage='$gameImage', gameDescription='$gameDescription')"
    }

}