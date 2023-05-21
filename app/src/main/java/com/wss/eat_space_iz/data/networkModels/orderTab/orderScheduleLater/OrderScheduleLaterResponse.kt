package com.wss.eat_space_iz.data.networkModels.orderTab.orderScheduleLater


import com.google.gson.annotations.SerializedName

data class OrderScheduleLaterResponse(
    @SerializedName("message")
    val data: OrderScheduleLaterData,
    @SerializedName("status")
    val status: String
)