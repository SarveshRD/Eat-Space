package com.wss.eat_space_iz.data.networkModels.blogsTab.viewRestaurantForBlog


import com.google.gson.annotations.SerializedName

data class ViewRestaurantForBlogResponce(
    @SerializedName("message")
    val data: List<Any>,
    @SerializedName("status")
    val status: String
)