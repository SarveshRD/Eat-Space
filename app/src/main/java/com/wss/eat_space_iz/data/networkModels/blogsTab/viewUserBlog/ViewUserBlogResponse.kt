package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog


import com.google.gson.annotations.SerializedName

data class ViewUserBlogResponse(
    @SerializedName("message")
    val data: ViewUserBlogData,
    @SerializedName("status")
    val status: String
)