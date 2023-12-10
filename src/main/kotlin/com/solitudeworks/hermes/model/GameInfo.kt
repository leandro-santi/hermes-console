package com.solitudeworks.hermes.model

import com.google.gson.annotations.SerializedName

class GameInfo(@SerializedName("info") val gameInfo: InfoApiShark) {

    override fun toString(): String {
        return gameInfo.toString();
    }

}