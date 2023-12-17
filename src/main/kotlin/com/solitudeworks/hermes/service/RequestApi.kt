package com.solitudeworks.hermes.service

import com.google.gson.Gson
import com.solitudeworks.hermes.model.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RequestApi {

    fun search(searchId: String): GameInfo? {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$searchId"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(url)).build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

        if (json.equals("[]")) return null;

        val gson = Gson()

        val infoGame: GameInfo = gson.fromJson(json, GameInfo::class.java)

        return infoGame;
    }

}