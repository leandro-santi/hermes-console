import com.google.gson.annotations.SerializedName

class GameInfo(@SerializedName("info") private val gameInfo: Game) {

    override fun toString(): String {
        return gameInfo.toString();
    }

}