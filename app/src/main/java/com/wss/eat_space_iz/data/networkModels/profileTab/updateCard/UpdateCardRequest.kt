package com.wss.eat_space_iz.data.networkModels.profileTab.updateCard


import com.google.gson.annotations.SerializedName

data class UpdateCardRequest(
    @SerializedName("card_id")
    val cardId: Int,
    @SerializedName("token")
    val token: String
)