package com.wss.eat_space_iz.data.networkModels.profileTab.followUser


import com.google.gson.annotations.SerializedName

data class FollowUserData(
    @SerializedName("following_user_id")
    val followingUserId: Int,
    @SerializedName("user_id")
    val userId: Int
)