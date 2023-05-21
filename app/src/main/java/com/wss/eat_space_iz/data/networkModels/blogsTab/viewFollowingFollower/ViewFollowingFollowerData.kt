package com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower


import com.google.gson.annotations.SerializedName

data class ViewFollowingFollowerData(
    @SerializedName("followers")
    val followers: List<Follower>,
    @SerializedName("following")
    val following: List<Following>
)