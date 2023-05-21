package com.wss.eat_space_iz.data.networkModels.profileTab.addCard


import com.google.gson.annotations.SerializedName

data class AddCardRequest(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: Int
)