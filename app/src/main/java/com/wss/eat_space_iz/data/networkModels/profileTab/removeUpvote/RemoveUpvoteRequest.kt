package com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote


import com.google.gson.annotations.SerializedName

data class RemoveUpvoteRequest(
    @SerializedName("blog_id")
    val blogId: Int,
    @SerializedName("user_id")
    val userId: Int
)