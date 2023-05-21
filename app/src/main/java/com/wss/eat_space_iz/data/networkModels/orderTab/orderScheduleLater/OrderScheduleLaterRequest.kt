package com.wss.eat_space_iz.data.networkModels.orderTab.orderScheduleLater


import com.google.gson.annotations.SerializedName

data class OrderScheduleLaterRequest(
    @SerializedName("order_data")
    val orderData: String,
    @SerializedName("scheduled_time")
    val scheduledTime: String,
    @SerializedName("user")
    val user: Int
)