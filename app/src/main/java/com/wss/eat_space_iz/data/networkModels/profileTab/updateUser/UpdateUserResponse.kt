package com.wss.eat_space_iz.data.networkModels.profileTab.updateUser


import com.google.gson.annotations.SerializedName

data class UpdateUserResponse(
    @SerializedName("message")
    val data: UpdateUserData,
    @SerializedName("status")
    val status: String
)