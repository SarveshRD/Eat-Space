package com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou


import com.google.gson.annotations.SerializedName

data class RecommendedForYouResponse(
    @SerializedName("message")
    val data: List<RecommendedForYouData>,
    @SerializedName("status")
    val status: String
)