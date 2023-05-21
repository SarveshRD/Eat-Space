package com.wss.eat_space_iz.data.networkModels.profileTab.updateCard


import com.google.gson.annotations.SerializedName

data class UpdateCardResponse(
    @SerializedName("message")
    val data: UpdateCardData,
    @SerializedName("status")
    val status: String
)