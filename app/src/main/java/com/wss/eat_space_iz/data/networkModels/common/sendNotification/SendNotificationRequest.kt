package com.wss.eat_space_iz.data.networkModels.common.sendNotification


import com.google.gson.annotations.SerializedName

data class SendNotificationRequest(
    @SerializedName("body")
    val body: String,
    @SerializedName("read")
    val read: Boolean,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: Int
)