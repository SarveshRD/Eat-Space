package com.wss.eat_space_iz.data.networkModels.orderTab.cancelOrder


import com.google.gson.annotations.SerializedName

data class CancelOrderRequest(
    @SerializedName("order_id")
    val orderId: Int,
    @SerializedName("order_status")
    val orderStatus: String
)