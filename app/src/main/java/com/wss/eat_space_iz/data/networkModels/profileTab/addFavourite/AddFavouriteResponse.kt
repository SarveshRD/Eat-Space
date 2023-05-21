package com.wss.eat_space_iz.data.networkModels.profileTab.addFavourite


import com.google.gson.annotations.SerializedName

data class AddFavouriteResponse(
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)