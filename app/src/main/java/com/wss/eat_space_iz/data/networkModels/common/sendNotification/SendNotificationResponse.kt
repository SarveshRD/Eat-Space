package com.wss.eat_space_iz.data.networkModels.common.sendNotification


import com.google.gson.annotations.SerializedName

data class SendNotificationResponse(
    @SerializedName("message")
    val data: SendNotificationData,
    @SerializedName("status")
    val status: String
)