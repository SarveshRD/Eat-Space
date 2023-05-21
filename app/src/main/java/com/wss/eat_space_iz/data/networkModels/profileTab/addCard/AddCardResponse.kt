package com.wss.eat_space_iz.data.networkModels.profileTab.addCard


import com.google.gson.annotations.SerializedName

data class AddCardResponse(
    @SerializedName("message")
    val data: AddCardData,
    @SerializedName("status")
    val status: String
)