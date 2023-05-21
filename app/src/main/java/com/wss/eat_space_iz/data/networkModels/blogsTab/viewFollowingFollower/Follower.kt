package com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower


import com.google.gson.annotations.SerializedName

data class Follower(
    @SerializedName("followers_count")
    val followersCount: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_pic")
    val profilePic: String,
    @SerializedName("user_id")
    val userId: Int
)