package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserRewardPoint


import com.google.gson.annotations.SerializedName

data class ViewUserRewardPointResponse(
    @SerializedName("message")
    val data: ViewUserRewardPointData,
    @SerializedName("status")
    val status: String
)