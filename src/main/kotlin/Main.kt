import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers

/*

    API consume using Java HTTPClient lib from Oracle Java SDK Docs

*/

fun main() {

    println("Hello World!")

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder().uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146")).build()

//    client.sendAsync(request, BodyHandlers.ofString())
//        .thenApply { obj: HttpResponse<*> -> obj.body() }
//        .thenAccept(System.out::println)
//        .join()

    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()

    println(json);

    val game: Game = Game() // Instance of Game's class
    game.gameTitle = "aaa"
    game.gameImage = "bbb"
    game.gameDescription = "ccc"

    println(game) // game.toString()
}