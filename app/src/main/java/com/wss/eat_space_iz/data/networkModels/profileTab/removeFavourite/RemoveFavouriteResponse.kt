package com.wss.eat_space_iz.data.networkModels.profileTab.removeFavourite


import com.google.gson.annotations.SerializedName

data class RemoveFavouriteResponse(
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)