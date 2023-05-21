package com.wss.eat_space_iz.data.networkModels.profileTab.addCard


import com.google.gson.annotations.SerializedName

data class AddCardData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: Int
)