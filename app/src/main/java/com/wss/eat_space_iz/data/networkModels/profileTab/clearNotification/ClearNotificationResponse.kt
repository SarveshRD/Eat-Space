package com.wss.eat_space_iz.data.networkModels.profileTab.clearNotification


import com.google.gson.annotations.SerializedName

data class ClearNotificationResponse(
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)