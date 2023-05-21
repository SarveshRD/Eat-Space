package com.wss.eat_space_iz.data.networkModels.orderTab.cancelOrder


import com.google.gson.annotations.SerializedName

data class CancelOrderResponse(
    @SerializedName("message")
    val data: CancelOrderData,
    @SerializedName("status")
    val status: String
)