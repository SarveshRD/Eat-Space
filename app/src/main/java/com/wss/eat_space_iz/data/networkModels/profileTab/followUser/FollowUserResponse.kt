package com.wss.eat_space_iz.data.networkModels.profileTab.followUser


import com.google.gson.annotations.SerializedName

data class FollowUserResponse(
    @SerializedName("message")
    val data: FollowUserData,
    @SerializedName("status")
    val status: String
)