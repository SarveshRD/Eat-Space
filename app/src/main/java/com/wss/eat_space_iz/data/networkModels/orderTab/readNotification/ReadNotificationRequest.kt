package com.wss.eat_space_iz.data.networkModels.orderTab.readNotification


import com.google.gson.annotations.SerializedName

data class ReadNotificationRequest(
    @SerializedName("notif_id")
    val notifId: Int
)