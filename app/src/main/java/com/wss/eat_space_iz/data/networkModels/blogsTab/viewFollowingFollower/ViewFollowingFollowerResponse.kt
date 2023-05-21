package com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower


import com.google.gson.annotations.SerializedName

data class ViewFollowingFollowerResponse(
    @SerializedName("message")
    val data: ViewFollowingFollowerData,
    @SerializedName("status")
    val status: String
)