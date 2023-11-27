import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

/*

    API consume using Java HTTPClient lib from Oracle Java SDK Docs

*/

fun main() {

    val scanner = Scanner(System.`in`) // Read id

    println("Enter a game id to search:")
    val search = scanner.nextLine()

    val url = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder().uri(URI.create(url)).build()

    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()

    val gson = Gson()
    val infoGame = gson.fromJson(json, GameInfo::class.java)

    val game = Game(infoGame.gameInfo.title, infoGame.gameInfo.steamAppID, infoGame.gameInfo.thumb)

    println(game)

}