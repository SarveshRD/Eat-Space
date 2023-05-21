package com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog


import com.google.gson.annotations.SerializedName

data class UpvoteBlogRequest(
    @SerializedName("blog_id")
    val blogId: Int,
    @SerializedName("user_id")
    val userId: Int
)