package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder


import com.google.gson.annotations.SerializedName

data class ViewAllOrderResponse(
    @SerializedName("message")
    val data: List<ViewAllOrderData>,
    @SerializedName("status")
    val status: String
)