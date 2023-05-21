package com.wss.eat_space_iz.data.networkModels.orderTab.readNotification


import com.google.gson.annotations.SerializedName

data class ReadNotificationResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)