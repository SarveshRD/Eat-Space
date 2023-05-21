package com.wss.eat_space_iz.data.networkModels.searchTab.trendingNearYou


import com.google.gson.annotations.SerializedName

data class TrendingNearYouResponse(
    @SerializedName("message")
    val data: List<TrendingNearYouData>,
    @SerializedName("status")
    val status: String
)