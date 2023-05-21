package com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou


import com.google.gson.annotations.SerializedName

data class ViewPopularNearYouResponse(
    @SerializedName("message")
    val data: List<ViewPopularNearYouData>,
    @SerializedName("status")
    val status: String
)