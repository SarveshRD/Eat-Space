package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog


import com.google.gson.annotations.SerializedName

data class ViewUserBlogData(
    @SerializedName("blogs")
    val blogs: List<Blog>,
    @SerializedName("user")
    val user: User
)