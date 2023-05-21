package com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog


import com.google.gson.annotations.SerializedName

data class UpvoteBlogResponse(
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)