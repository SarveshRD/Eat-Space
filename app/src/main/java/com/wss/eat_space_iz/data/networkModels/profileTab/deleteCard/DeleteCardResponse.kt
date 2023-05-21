package com.wss.eat_space_iz.data.networkModels.profileTab.deleteCard


import com.google.gson.annotations.SerializedName

data class DeleteCardResponse(
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)